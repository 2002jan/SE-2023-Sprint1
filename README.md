# Building Info
## SE-2023-Sprint1

----

# Description

For building administrators who want to minimise the costs of building management, our Building Info application will enable obtaining information about building parameters at the level of rooms, floors and entire buildings. The application will be available via GUI and also as a remote API, thanks to which it can be integrated with existing tools. 

# Data structure

```mermaid
classDiagram
    direction TB
    class Location{
        <<abstract>>
        +int id
        +String name
        +getArea()* float
        +getCubature()* float
        +getHeating()* float
        +getLighting()* float
    }
    class Building {
        +List~Level~ levels
        +addLevel(Level)
        +removeLevel(Level)
        +getLevels() List~Level~
    }
    class Level {
        +List~Room~ Rooms
        +addRoom(Room)
        +removeRoom(Room)
        +getRooms() List~Room~
    }
    class Room {
        +float area
        +float cube
        +float heating
        +float lighting
    }
    Location <|-- Building
    Location <|-- Level
    Location <|-- Room
```