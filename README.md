Mac OS X Text-To-Speech Web Service
===================================

This is a simple Mac text-to-speech web service, written
with the Play Framework and Scala.


Usage
-----

Start the Play server from the project's root directory by first
running the `play` command:

    $ play

Then start the service on port 8080:

    play> run 8080

Once it's running, the _postData.sh_ script shows how to call this web service.
That script looks like this:

    curl \
    --request POST \
    --data "text=hello%2C%20world&voice=Samantha" \
    http://localhost:8080/speak


More information
----------------

For more information, see this URL:

* http://alvinalexander.com/scala/mac-text-to-speech-web-service-play-framework
 

