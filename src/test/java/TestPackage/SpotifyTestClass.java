package TestPackage;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyTestClass {
    String token = "BQDu5YU93YVWVQfR1O8XBgxxotE0JLn_FLahnrXBu2hRNUYx7iJyBeWMTbYjp6vkUDOfWWFVnar67L76icHPvPbIh9qQtaLqLQfzGPhFkgZGcBL7B_KoQI1Oa1zEKVVpggTAGdf68nOETx7LqlI90ZOTH0tK-Yv7Vh5z3lEsODa_x88a4MR-vpOyP6JHTJI0M6ZhXUVZeNWSebUkp7auMkqI4L6Ny5LV3Cz0VZKwvjvhwXRNm8p8SvRj1KMBeArR-1e9gwXVUpG3bVSP";
    @Test
    void test() {
        Response res = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                        .get("https://api.spotify.com/v1/me");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void postRequest()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"name\": \"New Playlist\",\n" +
                        "    \"description\": \"New playlist description\",\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/31o33qhuwa3e4iw5o5tyxzutoznq/playlists");

        res.prettyPrint();
        res.then().assertThat().statusCode(201);
    }
    @Test
    public void getPlayListItems()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void addPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"uris\": [\n" +
                        "        \"spotify:track:3yHyiUDJdz02FZ6jfUbsmY\"\n" +
                        "    ],\n" +
                        "    \"position\": 0\n" +
                        "}")
                .when()
                        .post("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/tracks");

        res.prettyPrint();
        res.then().assertThat().statusCode(201);
    }
    @Test
    public void add2ndPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"uris\": [\n" +
                        "        \"spotify:track:0FBQ4NrrHUbR9kus7rzrOj\"\n" +
                        "    ],\n" +
                        "    \"position\": 1\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/tracks");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void updatePlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"range_start\": 1,\n" +
                        "    \"insert_before\": 3,\n" +
                        "    \"range_length\": 2\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/tracks");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void changePlayListDetails()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"name\": \"khushi\",\n" +
                        "    \"description\": \"Updated by khushi\",\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/tracks");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void removePlayListItems()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"tracks\": [\n" +
                        "         {\n" +
                        "            \"uri\": \"spotify:track:0FBQ4NrrHUbR9kus7rzrOj\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"snapshot_id\": \"OCxiYWM0MDllZjE4MGU2OTA0ZmQyZTBiYmFhZjE2NTRmYzYzMDA5NDAz\"\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/tracks");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void getCurrentUsersPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");

        res.prettyPrint();
        res.then().assertThat().statusCode(201);
    }
    @Test
    public void getUsersPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/users/31o33qhuwa3e4iw5o5tyxzutoznq/playlists");

        res.prettyPrint();
        res.then().assertThat().statusCode(201);
    }
    @Test
    public void createPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"name\": \"Twinkle\",\n" +
                        "    \"description\": \"New playlist \",\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/31o33qhuwa3e4iw5o5tyxzutoznq/playlists ");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void getFeaturedPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void getCetagoryPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner/playlists");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void getPlayListCoverImage()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner/playlists");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void addCustomPlayListCoverImage()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .put("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/images");

        res.prettyPrint();
        res.then().assertThat().statusCode(401);
    }


//    User
@Test
public void getCurrentUserProfile()
{
    Response res = given()
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + token)
            .when()
            .get("https://api.spotify.com/v1/me");

    res.prettyPrint();
    res.then().assertThat().statusCode(200);
}

    @Test
    public void getUsersTopItems()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/31o33qhuwa3e4iw5o5tyxzutoznq/top/artists");

        res.prettyPrint();
        res.then().assertThat().statusCode(404);
    }
    @Test
    public void getUserProfile()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/users/31o33qhuwa3e4iw5o5tyxzutoznq");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void followPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"public\": true\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/followers");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void unFollowPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/followers");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void getFollowedArtist()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/31o33qhuwa3e4iw5o5tyxzutoznq/following?type=artist");

        res.prettyPrint();
        res.then().assertThat().statusCode(404);
    }
    @Test
    public void followArtistOrUser()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"2oSONSC9zQ4UonDKnLqksx\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/31o33qhuwa3e4iw5o5tyxzutoznq/following?type=artist&ids=2oSONSC9zQ4UonDKnLqksx");

        res.prettyPrint();
        res.then().assertThat().statusCode(404);
    }
    @Test
    public void unFollowArtistOrUser()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/31o33qhuwa3e4iw5o5tyxzutoznq/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");

        res.prettyPrint();
        res.then().assertThat().statusCode(404);
    }
    @Test
    public void checkUserFollowArtist()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/31o33qhuwa3e4iw5o5tyxzutoznq/following/contains?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void checkUserFollowPlayList()
    {
        Response res = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/playlists/6miVuc50XIqnv3miHhMbIX/followers/contains?ids=31o33qhuwa3e4iw5o5tyxzutoznq");

        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

}
