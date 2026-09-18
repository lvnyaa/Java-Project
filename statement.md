# Problem Statement & System Scope

## Problem Statement
In urban transportation and fleet operations, calculating accurate passenger taxi fares manually or via unstandardized systems often leads to dynamic pricing errors, accounting discrepancies, and lack of transparency. Key variables such as base rates, distance tariffs, late-night surcharges, traffic peak-hour surge multipliers, and fixed toll charges must be computed consistently to ensure fair transactions and reliable record-keeping.

## Objective
The goal of this project is to implement a robust, object-oriented Java CLI application that automates taxi fare calculation, enforces customizable business rules for surge/night rates, produces itemized receipts, and logs completed transactions to local storage for auditing.

## Target Users
* **Taxi / Fleet Operators:** To calculate accurate fares for passengers with full fee transparency.
* **System Administrators:** To inspect auto-generated transaction logs (`transactions.txt`) for daily revenue and trip auditing.

## Core Features & System Scope
* **Modular Java Architecture:** Separation of concerns using `Main`, `Trip`, `FareCalculator`, and `BillingService` classes.
* **Dynamic Fare Logic:** Automatic evaluation of standard tariffs, peak-hour multiplier (1.5x), night surcharge (1.25x), and flat toll fees.
* **Data Persistence:** Automatic append-only logging of invoice details into `transactions.txt`.
* **Input Validation:** Error handling for invalid distances, time formats, or input types to prevent application crashes.
