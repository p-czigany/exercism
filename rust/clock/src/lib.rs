use std::cell::Cell;
use std::fmt;

#[derive(Debug)]
pub struct Clock {
    hours: i32,
    minutes: i32,
    cached_normal: Cell<Option<(i32, i32)>>,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        Clock {
            hours,
            minutes,
            cached_normal: Cell::new(None),
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Self::new(self.hours, self.minutes + minutes)
    }

    fn normal(&self) -> (i32, i32) {
        self.cached_normal.get().unwrap_or_else(|| {
            let normalized = (
                self.total_minutes().div_euclid(60).rem_euclid(24),
                self.total_minutes().rem_euclid(60),
            );
            self.cached_normal.set(Some(normalized));
            normalized
        })
    }

    fn total_minutes(&self) -> i32 {
        self.hours * 60 + self.minutes
    }
}

impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        let (hours, minutes) = self.normal();
        write!(f, "{:02}:{:02}", hours, minutes)
    }
}

impl PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        self.normal() == other.normal()
    }
}
