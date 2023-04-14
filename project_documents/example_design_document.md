# Example Project Design Doc - Amazon Music Playlist Service Design

Please use the following as a reference while completing your design. It has
been filled out with the details of the starter project you will be receiving,
based on the Unit 4 project.

## 1. Problem Statement

[Amazon Music Unlimited](https://www.amazon.com/b?ie=UTF8&node=15730321011) is a
premium music subscription service featuring tens of millions of songs available
to our millions of customers. We currently provide expert curated, pre-made
playlists, but customers have often requested the ability to create and manage
their own custom playlists.

This design document describes the Amazon Music Playlist Service, a new service that will provide the custom playlist functionality to meet
our customers' needs. It is designed to interact with the Amazon Music client
(which allows customers to stream music from their Amazon Music subscriptionDao to their
phone or computer) and will return a list of song metadata associated with the
playlist that the Amazon Music client can use to fetch the song file when
playing.

## 2. Top Questions to Resolve in Review

1. Should GET playlist and GET playlist/songs be separate endpoints? Will we
   regret not putting those together if by far the most common request for a
   playlist is getting the songs? 
2. We don't think ASIN + track number is the best unique identifier for songs
   (the same song might be on multiple albums, or there might be multiple ASINs
   for the same album, leading to weird duplicates). If we decide later on to
   change identifiers, will our current design make that too painful of a
   transition? Should we consider having our own songs table? Or have our own
   identifiers that *point to* ASINs + track numbers for now?
3. Do you know of any other teams out there who are working on related problems?
   Or might have the same concerns about how to identify a unique song?

## 3. Use Cases

U1. As a customer, I want to create a new, empty playlist with a given name and
a list of tags.

U2. As a customer, I want to retrieve my playlist with a given ID.

U3. As a customer, I want to update my playlist name.

U4. As a customer, I want to add a song to the end of my playlist.

U5. As a customer, I want to add a song to the beginning of my playlist.

U6. As a customer, I want to retrieve all songs in my playlist.

U7. As a customer, I want to retrieve all songs in my playlist in a provided
order (default order, reverse order, shuffled).

## 4. Project Scope

### 4.1. In Scope

* Creating, retrieving, and updating a playlist
* Adding to and retrieving a saved playlist's list of songs

### 4.2. Out of Scope

* Updating playlist tags
* Integration with Amazon Music Client
* When adding a song on the website, having a drop down or autocomplete with the
  different songs available.
* The ability to play music from the website
* The ability to search for existing songs either through the website or the API
* Being able to add tags individually or in some nicer way than a comma
  separated list of strings on the website
* Sharing playlists between users

## 5. Proposed Architecture Overview

This initial iteration will provide the minimum lovable product (MLP) including
creating, retrieving, and updating a playlist, as well as adding to and
retrieving a saved playlist's list of songs.

We will use API Gateway and Lambda to create five endpoints (`GetPlaylist`,
`CreatePlaylist`, `UpdatePlaylist`, `AddSongToPlaylist`, and `GetPlaylistSongs`)
that will handle the creation, update, and retrieval of playlists to satisfy our
requirements.

We will store songs available for playlists in a table in DynamoDB. Playlists
themselves will also be stored in DynamoDB. For simpler song list retrieval, we
will store the list of songs in a given playlist directly in the playlists
table.

AmazonMusicPlaylistService will also provide a web interface for users to manage
their playlists. A main page providing a list view of all of their playlists
will let them create new playlists and link off to pages per-playlist to update
metadata and add songs.

## 6. API


### 6.2. Get Appointment Endpoint

* Accepts `GET` requests to `/appointments/:id`
* Accepts a appointment ID and returns the corresponding AppointmentModel.
    * If the given appointment ID is not found, will throw a
      `AppointmentNotFoundException`

### 6.3. Create Appointment Endpoint

* Accepts `POST` requests to `/appointments`
* Accepts data to create a new appointment with a provided address, a given unique appointmentId
  ID, a unique patient ID assigned by the patientUtil class, contactInfo, dentistName and other
* information needed.

### 6.4. Update Appointment Endpoint

* Accepts `PUT` requests to `/playlists/:id`
* Accepts data to update an Appointment base on the fields you want to update. Returns the updated
  appointment.
    * If the appointment ID is not found, will throw an `AppointmentNotFoundException`

### 6.1. Public Models

```
// AppointmentModel

  private String appointmentId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String patientName;
    private String patientId;
    private String dentistName;
    private String description;
    private String service;
    private String address;
    private String contactInfo;
```


## 7. Tables

### 7.1. `appointments`

```
appointmentId // partition key, string
address // string
contactInfo // string
dentistName // string
description // string
endTime // string
patientId// string
patientName// string
service// string
startTime// string
```

## 8. Pages

![Clicking on services link opens the services page.
Clicking on Online Appointment link opens the Online Appointment page. Clicking on Check Appointment
link opens the Check Appointment page..
Clicking the Book an Appointment button opens the Online Appointment Page
](images/Front-End/images/HomePage.png)

![The services page says ](images/Front-End/images/Services.png)

![The view playlist page has the name of the playlist and any tags associated
with it. Each song in the playlist is listed in order. There is a plus button
to add a new song to the
playlist.](images/Front-End/images/OnlineAppointment.png)

![The add song page has a form titled "Add Song." It displays the playlist name
followed by fields for the asin and track number. THere is a check box for
queue next. Finally, there is an "Add" button to submit the
form.](images/Front-End/images/CheckAppointment.png)
