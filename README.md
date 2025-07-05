# Restaurant Booking Demo

## Requirements
- Java 17+
- Maven 3.9+

## Build & Run
```bash
git clone https://github.com/Harsha54443/restaurant-booking.git
cd restaurant-booking
mvn clean compile exec:java \
  -Dexec.mainClass="com.interview.Main" \
  -Dexec.cleanupDaemonThreads=false
