/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.alexandroid.udacity.sample;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "sample.udacity.alexandroid.com",
                ownerName = "sample.udacity.alexandroid.com",
                packagePath = ""
        )
)

public class MyEndpoint {
    /**
     * A simple endpoint method that returns some joke
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        Joke response = new Joke();
        response.setJoke("Some joke is here...");
        return response;
    }

}
