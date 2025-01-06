#[derive(Debug)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        Clock {
            hours,
            minutes,
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Self::new(self.hours, self.minutes + minutes)
    }

    pub fn to_string(&self) -> String {
        format!("{:02}:{:02}", self.normal().hours, self.normal().minutes)
    }

    fn normal(&self) -> Self {
        Self::new(self.total_minutes().div_euclid(60).rem_euclid(24), self.total_minutes().rem_euclid(60))
    }

    fn total_minutes(&self) -> i32 {
        self.hours * 60 + self.minutes
    }
}

impl PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        self.normal().hours == other.normal().hours && self.normal().minutes == other.normal().minutes
    }
}
