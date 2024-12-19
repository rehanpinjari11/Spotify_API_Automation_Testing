package spotify_api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Spotify_Api_Automation {

    String url = "BQCTuFVfjEDqMdeZOk294SCMXP-xqqkVh7inOFpW2nt0VdDkQV8OJa2r8MK-ldc66mv4INdingxjyzlzF_A-QsFkyjtsF8FymTreoBC84h7TsGoub6-H7JgacT0OeYMfR2AlByi0Ae0UtV_b7RQNIdpkv0mY1aGCx90n75AItwMQA7dR5UMyBb_HikgXIwwYIj_k1Lki8QFbken8gnfSypqMfaBmqegO_R4IBuNsS-yJFj4ch8KXLHy3p_RLkfvAY-oIDfAjO2hhfVa2wZMWhtl-BjBaQzDr1fuKvhRsPudOGdPTJx0Xsc_AyiJFId_MIsf9YxVATJR_XvBuQw-N2fs";

    //Users

    @Test
    public void getCurrentUserProfile() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUserTopItems() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/top/artists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUserProfile() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/users/smedjan");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void followPlaylist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void unfollowPlaylist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getFollowedArtists() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/following?type=artist");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void followArtistsOrUsers() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .put("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void unfollowArtistsOrUsers() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .delete("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkIfUserFollowsArtistsOrUsers() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkIfCurrentUserFollowsPlaylist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

//    Tracks

    @Test
    public void getTrack() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralTracks() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUsersSavedTracks() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveTrackForCurrentUser() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeUserSavedTracks() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .delete("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkUserSavedTracks() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .delete("https://api.spotify.com/v1/me/tracks/contains?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

//    Playlist

    @Test
    public void getPlaylist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void changePlaylistDetails() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void getPlaylistItems() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void updatePlaylistItems() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void addItemsToPlaylist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void removePlaylistItems() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void getCurrentUserPlaylist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void getUserPlaylist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .put("https://api.spotify.com/v1/users/smedjan/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void createPlaylist() {
        Response res = given()
                .auth().oauth2("BQDAsTFC8zgCQo3MCjyPx06X3_Bm_dMVDeujC1mUoeD1wjoHkTVyKvm075L-FgIDC5Z72nizlPXXcYCpSAhiBnpUMv0MoaO969l104rrd-jNv11WUWRBxmI6X-VPBvcx7v3a9sV4dUadjqwjbqj0lU_K2wykhzxHoPDRtrfnsSAsTqTN4dsJcQH9Unw2Yh4MKZZ38CWIygCOYYEAecCEBhN4_6u88h3XwiL3eunOSZbIRwuEmDu2uXzzlwGPalvdjelYjHO2rNzcaIsEB5Td8Zi8o7H4-vYt7c59MaoosFVXqiz8lo5tHOhVPtYSyjq4bVKNI49plqHsohsbcYcQn94")
                .when()
                .post("https://api.spotify.com/v1/users/smedjan/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

//    Album

    @Test
    public void getAlbum() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralAlbum() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getAlbumTracks() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUsersSavedAlbum() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/albums");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveAlbumForCurrentUser() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeUsersSavedAlbum() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkUsersSavedAlbum() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/albums/contains?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getNewReleases() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

//    Artists

    @Test
    public void getArtist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralArtist() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6   ");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getArtistAlbum() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getArtistTopTracks() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getArtistsRelatedArtists() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

//    Shows

    @Test
    public void getShow() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralShows() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getShowEpisodes() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUsersSavedShows() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/shows");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveShowsForCurrentUser() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeUsersSavedShows() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .delete("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkUsersSavedShows() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .delete("https://api.spotify.com/v1/me/shows/contains?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

//    Audiobooks

    @Test
    public void getAnAudiobook() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/audiobooks/7iHfbu1YPACw6oZPAFJtqe");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralAudiobook() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/audiobooks?ids=18yVqkdbdRvS24c0Ilj2ci%2C1HGw3J3NxZO1TP1BTtVhpZ%2C7iHfbu1YPACw6oZPAFJtqe");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getAudiobookChapters() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/audiobooks/7iHfbu1YPACw6oZPAFJtqe/chapters");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void usersSavedAudiobook() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void savedAudiobookForCurrentUser() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks?ids=18yVqkdbdRvS24c0Ilj2ci%2C1HGw3J3NxZO1TP1BTtVhpZ%2C7iHfbu1YPACw6oZPAFJtqe");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkUsersSavedAudiobooks() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks/contains?ids=18yVqkdbdRvS24c0Ilj2ci%2C1HGw3J3NxZO1TP1BTtVhpZ%2C7iHfbu1YPACw6oZPAFJtqe");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    //Categories

    @Test
    public void getSeveralBrowserCategories() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/browse/categories");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSingleBrowserCategories() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

//    Chapters

    @Test
    public void getChapter() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/chapters/0D5wENdkdwbqlrHoaJ9g29");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralChapters() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/chapters?ids=0IsXVP0JmcB2adSE338GkK%2C3ZXb8FKZGU0EHALYX6uCzU%2C0D5wENdkdwbqlrHoaJ9g29");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

//    Episodes

    @Test
    public void getEpisodes() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getSeveralEpisodes() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getUserSavedEpisodes() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/episodes");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void savedEpisodesForCurrentUsers() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void RemoveUsersSavedEpisodes() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .delete("https://api.spotify.com/v1/me/episodes?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkUsersSavedEpisodes() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/episodes/contains?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getAvailableMarkets() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/markets");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

//    Player

    @Test
    public void getPlaybackState() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/player");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void transferPlayback() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/player");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getAvailableDevices() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/player/devices");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getCurrentlyPlayingTrack() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/me/player/currently-playing");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    //    Search

    @Test
    public void searchForItem() {
        Response res = given()
                .auth().oauth2(url)
                .when()
                .get("https://api.spotify.com/v1/search?q=remaster%2520track%3ADoxy%2520artist%3AMiles%2520Davis&type=album");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }


}




