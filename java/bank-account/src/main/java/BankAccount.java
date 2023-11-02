import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {

    private int balance;
    private boolean isOpen;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();


    BankAccount() {
        this.balance = 0;
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public void deposit(int sum) throws BankAccountActionInvalidException {
        try {
            writeLock.lock();
            validateForOpenness();
            validateForNegativeSum(sum);
            balance += sum;
        } finally {
            writeLock.unlock();
        }
    }

    public void withdraw(int sum) throws BankAccountActionInvalidException {
        try {
            writeLock.lock();
            validateForOpenness();
            validateForNegativeSum(sum);
            validateForEmptyAccount();
            validateForOverCharging(sum);
            balance -= sum;
        } finally {
            writeLock.unlock();
        }

    }

    private void validateForNegativeSum(int sum) throws BankAccountActionInvalidException {
        if (sum < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }

    private void validateForEmptyAccount() throws BankAccountActionInvalidException {
        if (balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
    }

    private void validateForOverCharging(int sum) throws BankAccountActionInvalidException {
        if (balance < sum) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
    }

    public int getBalance() throws BankAccountActionInvalidException {
//        try {
//            readLock.lock();
            validateForOpenness();
            return balance;
//        } finally {
//            readLock.unlock();
//        }
    }

    private void validateForOpenness() throws BankAccountActionInvalidException {
        if (!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }
}
