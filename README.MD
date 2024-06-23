# Enrollment Management System

## Introduction
This project implements a backend system for managing enrollments of participants in various educational events. The application allows efficient management of participants, providing functionalities for adding, checking, updating, and removing participants, as well as managing a waitlist.

## Project Structure
The project is structured into three main classes:
1. **Guest**: Represents a participant in an event.
2. **GuestsList**: Manages the list of participants.
3. **Main**: The main interface of the application for user interaction.

### Class 'Guest'
A guest is defined by the following attributes:
- last name
- first name
- email
- phone number

### Class 'GuestsList'
The `GuestsList` class manages event enrollments, including:
- Number of available seats
- List of participants
- Waitlist of participants

#### Functionalities:
- Adding a new person
- Checking if a person is enrolled
- Removing a person
- Updating a person's details
- Getting the list of participants
- Getting the waitlist
- Getting the number of available seats
- Getting the number of participants
- Getting the number of people on the waitlist
- Getting the total number of enrolled people
- Partial search by substring

### Class 'Main'
The `Main` class manages user interaction via the command line and calls methods from `GuestsList` to fulfill user requirements.

#### Command Set:
- `help`: Displays the list of available commands
- `add`: Adds a new person
- `check`: Checks if a person is enrolled
- `remove`: Removes an existing person
- `update`: Updates details of a person
- `guests`: Displays the list of participants
- `waitlist`: Displays the waitlist
- `available`: Displays the number of available seats
- `guests_no`: Displays the number of event participants
- `waitlist_no`: Displays the number of people on the waitlist
- `subscribe_no`: Displays the total number of enrolled people
- `search`: Searches guests by substring
- `quit`: Closes the application
