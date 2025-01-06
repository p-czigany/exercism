#[derive(Debug)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        Clock {
            hours: hours,
            minutes: minutes,
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Self::new(self.hours, self.minutes + minutes)
    }

    pub fn to_string(&self) -> String {
        let total_minutes = self.hours * 60 + self.minutes;
        let normalized_hours = total_minutes.div_euclid(60).rem_euclid(24);
        let normalized_minutes = total_minutes.rem_euclid(60);
        format!("{:02}:{:02}", normalized_hours, normalized_minutes)
    }
}

impl PartialEq for Clock {
    fn eq(&self, other: &Self) -> bool {
        let self_total_minutes = self.hours * 60 + self.minutes;
        let self_normalized_hours = self_total_minutes.div_euclid(60).rem_euclid(24);
        let self_normalized_minutes = self_total_minutes.rem_euclid(60);

        
        let other_total_minutes = other.hours * 60 + other.minutes;
        let other_normalized_hours = other_total_minutes.div_euclid(60).rem_euclid(24);
        let other_normalized_minutes = other_total_minutes.rem_euclid(60);


        self_normalized_hours == other_normalized_hours && self_normalized_minutes == other_normalized_minutes
    }
}
