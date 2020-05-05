
/**
 * This class preforms dates calculations.
 * <p>
 * More information about how to use it and what it can do
 * can be found in the API documentation.
 *
 * @author Netanel Shoshan.
 * @version 11/12/2019
 */

public class Date {
    // Instance variables.
    private int _day;
    private int _month;
    private int _year;

    // Final variables.
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000;


    /**
     * Crates a new Date object if the date is valid,
     * otherwise creates the date 1/1/2000.
     *
     * @param day   gets the day.
     * @param month gets the month.
     * @param year  gets the year.
     */
    public Date(int day, int month, int year) {

        /* Sending user input for validation to the validDate method.
        if true - will assign the date, otherwise will assign
         01/01/2000 */
        if (validDate(day, month, year)) {
            _day = day;
            _month = month;
            _year = year;
        } else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    } // End of Date constructor.

    /**
     * The copy constructor.
     *
     * @param other other date to copy.
     */
    public Date(Date other) {
        _day = other._day;
        _month = other._month;
        _year = other._year;

    }// End of Date (copy constructor).

    /**
     * Calculates if the day is a valid day.
     *
     * @param day   the day.
     * @param month the month.
     * @param year  the year.
     * @return true if the date is valid, otherwise return false.
     */
    private boolean validDate(int day, int month, int year) {
        /* Assigning months to boolean variables.
        a = Months with 31 days.
        b = Months with 30 days.
        c = Month with 28 or 29 days depending of it's a leap year or not.
         */
        final boolean a = month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12;
        final boolean b = month == 4 || month == 6 || month == 9 || month == 11;
        final boolean c = month == 2;

        if (yearInRange(year)) {
            if (calculateLeap(year))
                if (a) {
                    return day <= 31 && day > 0;
                } else if (b) {
                    return day <= 30 && day > 0;
                } else if (c) {
                    return day <= 29 && day > 0;

                }
        }
        // This if statement will be executed only if the year is NOT a leap year.
        if (yearInRange(year)) {
            if (!calculateLeap(year))
                if (a) {
                    return day <= 31 && day > 0;
                } else if (b) {
                    return day <= 30 && day > 0;
                } else if (c) {
                    return day <= 28 && day > 0;
                }
        }
        return false;
    }// End of validDate method.

    /**
     * Checks if the year is a valid year.
     *
     * @param year year to check
     * @return true if the year is valid, false otherwise.
     */
    private boolean yearInRange(int year) {
        return 1000 <= year && year < 10000;
    }

    /**
     * Calculate if the year is a leap year.
     *
     * @param year the year to check.
     * @return true if it's leap year, otherwise returns false.
     */
    private boolean calculateLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    } // End of calculateLeap method.

    /**
     * Calculate tomorrows date.
     *
     * @return Tomorrows date.
     */
    public Date tomorrow() {   // Assigning the date to new variables.
        int newDay = _day;
        int newMonth = _month;
        int newYear = _year;

        /* This if statement will be executed only if the year is a < LEAP YEAR >.
        Afterwards, it will evaluate and return the next day based on the month and the
        number of days on the given month.
         */
        if (calculateLeap(_year)) {
            if (_month == 1 || _month == 3 || _month == 5 || _month == 7 ||
                    _month == 8 || _month == 10 || _month == 12) {
                if (_month == 12 && _day == 31) {
                    newDay = DEFAULT_DAY;
                    newMonth = DEFAULT_MONTH;
                    newYear = _year + 1;
                } else if (_month < 12 && _day == 31) {
                    newDay = DEFAULT_DAY;
                    newMonth = _month + 1;
                    newYear = _year;
                } else if (_month <= 12 && _day <= 30) {
                    newDay = _day + 1;
                    newMonth = _month;
                    newYear = _year;
                }

            } else if (_month == 4 || _month == 6 || _month == 9 || _month == 11) {
                if (_day == 30) {
                    newDay = DEFAULT_DAY;
                    newMonth = _month + 1;
                    newYear = _year;
                } else if (_day <= 29) {
                    newDay = _day + 1;
                    newMonth = _month;
                    newYear = _year;
                }
            } else if (_month == 2) {
                if (_day <= 28) {
                    newDay = _day + 1;
                    newMonth = _month;
                    newYear = _year;
                } else if (_day == 29) {
                    newDay = DEFAULT_DAY;
                    newMonth = _month + 1;
                    newYear = _year;
                }
            }
        }
        /* This if statement will be executed only if the year is < NOT A LEAP YEAR >.
        Afterwards, it will evaluate and return the next day based on the month and the
        number of days on the given month.
         */
        else if (!calculateLeap(_year)) {
            if (_month == 1 || _month == 3 || _month == 5 || _month == 7 ||
                    _month == 8 || _month == 10 || _month == 12) {
                if (_month == 12 && _day == 31) {
                    newDay = DEFAULT_DAY;
                    newMonth = DEFAULT_MONTH;
                    newYear = _year + 1;
                } else if (_month < 12 && _day == 31) {
                    newDay = DEFAULT_DAY;
                    newMonth = _month + 1;
                    newYear = _year;
                } else if (_month <= 12 && _day <= 30) {
                    newDay = _day + 1;
                    newMonth = _month;
                    newYear = _year;
                }
            } else if (_month == 4 || _month == 6 || _month == 9 || _month == 11) {
                if (_day == 30) {
                    newDay = DEFAULT_DAY;
                    newMonth = _month + 1;
                    newYear = _year;
                } else if (_day <= 29) {
                    newDay = _day + 1;
                    newMonth = _month;
                    newYear = _year;
                }
            } else if (_month == 2) {
                if (_day <= 27) {
                    newDay = _day + 1;
                    newMonth = _month;
                    newYear = _year;
                } else if (_day == 28) {
                    newDay = DEFAULT_DAY;
                    newMonth = _month + 1;
                    newYear = _year;
                }
            }
        }
        return new Date(newDay, newMonth, newYear);
    } // End of tomorrow method.


    /**
     * Computes the day number since the beginning of the christian counting of years.
     *
     * @param day   gets the day.
     * @param month gets the month.
     * @param year  gets the year.
     * @return the number of days since the beginning of the christian counting
     * of years until this date.
     */
    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    } // End of calculateDate method.


    /**
     * Calculates the difference between two dates.
     *
     * @param other The date to calculate the difference between.
     * @return The number of days between the dates.
     */
    public int difference(Date other) {
        // Calculating the day number using the calculateDate function and returns the diff.
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    } // End of difference method.

    /**
     * Calculate the day of the week that this date occurs on.
     * 0-Saturday 1-Sunday 2-Monday etc.
     *
     * @return The day of the week that this date occurs on
     */

    public int dayInWeek() {
        int D = _day; // The day.
        int M = _month; // The month.
        int y = _year; // The year
        if (M < 3) // If month is less then 3, will approach it as if it's not a leap year.
        {
            M += 12;
            --y;
        }
        int C = y / 100; // First two digits of a year.
        int Y = y % 100; // Last two digits of a year.
        int theDay = Math.floorMod(D + 26 * (M + 1) / 10 + Y + Y / 4 + C / 4 - 2 * C, 7);
        return theDay;
    } // End of dayInWeek method.

    /**
     * Gets the day.
     *
     * @return the day.
     */
    public int getDay() {
        return _day;
    } // End of getDay method.

    /**
     * Gets the month.
     *
     * @return the month
     */
    public int getMonth() {
        return _month;
    } // End of getMonth method.

    /**
     * Gets the year.
     *
     * @return the year.
     */
    public int getYear() {
        return _year;
    } // End of getYear method.

    /**
     * Sets the day (only if the date remains valid).
     *
     * @param dayToSet the day value to be set.
     */
    public void setDay(int dayToSet) {
        if (validDate(dayToSet, _month, _year))
            _day = dayToSet;
    } // End of setDay method.

    /**
     * Sets the month (only if the date remains valid).
     *
     * @param monthToSet the month value to be set.
     */
    public void setMonth(int monthToSet) {
        if (validDate(_day, monthToSet, _year))
            _month = monthToSet;
    }// End of setMonth method.

    /**
     * Sets the year (only if the year remains valid).
     *
     * @param yearToSet the year value to be set.
     */
    public void setYear(int yearToSet) {
        if (validDate(_day, _month, yearToSet))
            _year = yearToSet;
    }// End of setYear method.

    /**
     * Check if this date is before the other date.
     *
     * @param other The date to compare this date to.
     * @return True if this date is before the other date,
     * otherwise, return false.
     */
    public boolean before(Date other) {
        return _year < other._year ||
                _year == other._year && _month < other._month ||
                _year == other._year && _month == other._month &&
                        _day < other._day;
    }// End of before method.

    /**
     * Check if this date is after the other date.
     *
     * @param other The date to compare this date to.
     * @return True if this date is after the other date,
     * otherwise, return false.
     */
    public boolean after(Date other) {
        return (other.before(this));
    }// End of after method.

    /**
     * Checks if 2 dates are the same
     *
     * @param other The date to compare to.
     * @return True if the dates equal. otherwise return false.
     */
    public boolean equals(Date other) {
        return (this._day == other._day && this._month == other._month && this._year == other._year);

    }// End of equals method.

    /**
     * Returns a string that represent the date
     * The if-else Statements evaluate whe
     */
    public String toString() {
        // Creating empty string so we could assign him the date later on.
        String str = "";

        // Will add 0 before the day and the month 01/02/2019
        if (_day < 10 && _month < 10)
            str = "0" + _day + "/" + "0" + _month + "/" + _year;
            // Will add 0 zero before the month.
        else if (_day >= 10 && _month < 10)
            str = _day + "/" + "0" + _month + "/" + _year;
            // There's no need to add zeros.. so will assign the date as is.
        else
            str = _day + "/" + _month + "/" + _year;
        return str;
    } // End of toString method.
} // End of Date class.