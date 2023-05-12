# Building Info
## SE-2023-Sprint1

![verification workflow](https://github.com/2002jan/SE-2023-Sprint1/actions/workflows/ci.yml/badge.svg)

## Description

For building administrators who want to minimise the costs of building management, our Building Info application will enable obtaining information about building parameters at the level of rooms, floors and entire buildings. The application will be available via GUI and also as a remote API, thanks to which it can be integrated with existing tools. 

## Data structure

```mermaid
classDiagram
    direction TB
    class Location{
        <<abstract>>
        +int id
        +String name
        +getArea()* int
        +getVolume()* int
        +getHeatingEnergy()* float
        +getLightingPower()* int
        +getRoomsExeceedingHeatingEnergy(float limit) List~Room~
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
        +int area
        +int cube
        +float heating
        +int lighting
    }
    Location <|-- Building
    Location <|-- Level
    Location <|-- Room
```

## Project backlog

[Project backlog in google docs](https://docs.google.com/spreadsheets/d/1l14yDciC1lDoUGGHsX6Y3OOe6MKf3woWP7lQfPoqkEs/edit?usp=sharing)