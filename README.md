# Building Info
## SE-2023-Sprint1

![verification workflow](https://github.com/2002jan/SE-2023-Sprint1/actions/workflows/ci.yml/badge.svg)

## Description

For building administrators who want to minimise the costs of building management, our Building Info application will enable obtaining information about building parameters at the level of rooms, floors and entire buildings. The application will be available via GUI and also as a remote API, thanks to which it can be integrated with existing tools. 

## Data structure

```mermaid
classDiagram
    direction LR
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
    class LocationContainer {
        <<abstract>>
        #addLocation(Location)
        #getLocations(): List~Location~
    }
    class Building {
        +addLevel(Level)
    }
    class Level {
        +addRoom(Room)
    }
    class Room {
        +int area
        +int cube
        +float heating
        +int lighting
    }
    Location <|-- Room
    LocationContainer <|-- Level
    LocationContainer <|-- Building
    Location <|-- LocationContainer
    Location o-- LocationContainer
```

## Project backlog

[Project backlog in google docs](https://docs.google.com/spreadsheets/d/1l14yDciC1lDoUGGHsX6Y3OOe6MKf3woWP7lQfPoqkEs/edit?usp=sharing)