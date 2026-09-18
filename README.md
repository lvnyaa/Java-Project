# Taxi Billing & Fleet Management System

## Description
The **Taxi Billing & Fleet Management System** is a modular, command-line Java application designed to standardize taxi fare calculations, automate billing, and log trip data. 

In real-world transport operations, manual fare computation often leads to discrepancies due to complex parameters like late-night tariffs, peak-hour traffic surge pricing, and toll fees. This software solves those challenges by providing a reliable business logic engine that calculates accurate trip fares dynamically, outputs itemized receipts, and automatically records transaction logs for audit and fleet management purposes.

---

## Features
* **Trip & Route Input Management:** Validates trip metrics including distance, duration, passenger details, tolls, and time of day.
* **Dynamic Fare Computation Engine:** Computes base rates, distance tariffs, night surcharges (1.25x factor), peak-hour surge multipliers (1.50x factor), and flat toll fees.
* **Itemized Billing & Invoicing:** Generates structured receipts displaying full cost breakdowns for passengers and drivers.
* **Transaction Logging:** Persists completed trip records into structured local log files (`transactions.txt`).
* **Robust Error Handling:** Guarantees program stability against invalid inputs (e.g., negative distances, invalid hours, or invalid data types).

---

## Technologies Used
* **Programming Language:** Java (JDK 11 or higher)
* **Development Environment:** Visual Studio Code / Eclipse / IntelliJ IDEA
* **Execution Environment:** Command Line Interface (CLI) / Terminal
* **Version Control:** Git & GitHub

---

## Project Structure
```text
taxi-billing-system/
│
├── README.md               # Project documentation and execution guide
├── statement.md            # Problem statement, scope, target users, and features
├── transactions.txt        # Local storage log for completed trip invoices
│
└── src/
    ├── Main.java           # Program entry point and CLI menu interface
    ├── Trip.java           # Trip data model and input validation logic
    ├── FareCalculator.java # Core business logic for fares, surcharges, and tolls
    └── BillingService.java # Invoice generation and transaction logging service
```
## Setup & Installation

### Prerequisites
Ensure you have the Java Development Kit (JDK 11 or higher) installed on your system. Verify installation by opening your terminal and running:
```bash
java -version
javac -version
```
### Installation Steps
1. Clone this repository to your local machine:
   ```bash
   git clone [https://github.com/kriti25bai10713-hue/taxi-billing-system.git](https://github.com/kriti25bai10713-hue/taxi-billing-system.git)

# 1. Compile all Java files inside the src directory
javac src/*.java

# 2. Execute the Main program from the root directory
java -cp src Main
