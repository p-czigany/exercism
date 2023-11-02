class MicroBlog {
    private static final int MAX_N_OF_CHARACTERS = 5;

    public String truncate(String input) {

        return input.codePoints().limit(MAX_N_OF_CHARACTERS).collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
        ).toString();
    }
}
