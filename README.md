# Task Management System

A Java-based task scheduling and execution system that handles both one-time and recurring tasks.

## Features

- **Task Types**:
  - `SimpleTask`: One-time execution tasks
  - `RecurringTask`: Tasks that repeat at specified intervals
- **Task Handler**:
  - Manages task execution in tick-based cycles
  - Automatic removal of completed tasks
  - Thread-safe task operations
- **ID Generation**: Automatic unique ID generation for all tasks

## Class Structure

### Core Classes

1. **AbstractTask** (Abstract Base Class)
   - Properties: `message`, `runAtTick`, `taskId`
   - Key Methods: `isScheduledAt()`, `run()`, `isFinished()`
   
2. **SimpleTask** (Concrete Class)
   - Executes once at specified tick
   - Auto-removes after execution

3. **RecurringTask** (Concrete Class)
   - Repeats at fixed intervals
   - Configurable number of repetitions (or infinite)

4. **TaskHandler**
   - Manages task lifecycle:
     - `addTask()`
     - `removeTask()`
     - `tickLoop()`
   - Maintains task array with automatic resizing

### Support Classes

- `TaskIdGenerator`: Generates unique task IDs

## Usage Example

```java
// Create handler
TaskHandler handler = new TaskHandler();

// Add tasks
handler.addTask(new SimpleTask("Buy groceries", 1));
handler.addTask(new RecurringTask("Brush teeth", 1, 2, 3)); // Runs at ticks 1,3,5

// Run simulation
handler.tickLoop(6);

