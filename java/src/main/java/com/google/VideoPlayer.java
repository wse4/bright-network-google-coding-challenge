package com.google;
import java.util.*;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  // Video that is playing.
  private Video nowPlaying;
  // If there is a video currently playing.
  private boolean isPlaying = false;
  Random rand = new Random();
  private Video pausedVideo;
  private boolean isPaused = false;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:%n");
    // Turn ArrayList of Videos into ArrayList of Strings to use sort() function.
    ArrayList<String> temp = new ArrayList<>();
    for (int i = 0; i < videoLibrary.getVideos().size(); i++ ){
      temp.add(videoLibrary.getVideos().get(i).getTitle() + " (" + videoLibrary.getVideos().get(i).getVideoId()
              + ") " + videoLibrary.getVideos().get(i).getTags());
    }
    Collections.sort(temp);
    for (int i = 0; i < temp.size(); i++ ){
      System.out.println(temp.get(i).replaceAll(",",""));
    }
  }

  public void playVideo(String videoId) {
    // Check if the video is not null and no video is playing
    if (videoLibrary.getVideo(videoId) != null && !isPlaying){
      isPlaying = true;
      isPaused = false;
      nowPlaying = videoLibrary.getVideo(videoId);
      System.out.println("Playing video: " + nowPlaying.getTitle());
    }
    // Check if a video is already playing
    else if (videoLibrary.getVideo(videoId) != null && isPlaying){
      System.out.println("Stopping video: " + nowPlaying.getTitle());
      nowPlaying = videoLibrary.getVideo(videoId);
      System.out.println("Playing video: " + nowPlaying.getTitle());
    }
    else {
      System.out.println("Cannot play video: Video does not exist");
    }
  }

  public void stopVideo() {
    if (isPlaying){
      System.out.println("Stopping video: " + nowPlaying.getTitle());
      nowPlaying = null;
      isPlaying = false;
    }
    else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    if (!isPlaying){
      // Get random video in the video library
      Video randomPlay = videoLibrary.getVideos().get(rand.nextInt(videoLibrary.getVideos().size() - 1));
      playVideo(randomPlay.getVideoId());
    }
    else{
      // Stop video first if there is a video playing
      stopVideo();
      Video randomPlay = videoLibrary.getVideos().get(rand.nextInt(videoLibrary.getVideos().size() - 1));
      playVideo(randomPlay.getVideoId());
    }
  }

  public void pauseVideo() {
    if (isPlaying && !isPaused) {
      pausedVideo = nowPlaying;
      System.out.println("Pausing video: " + pausedVideo.getTitle());
      isPaused = true;
    }
    else if (isPaused){
      System.out.println("Video already paused: " + pausedVideo.getTitle());
    }
    else {
      System.out.println("Cannot pause video: No video is currently playing");
    }
  }

  public void continueVideo() {
    if (isPaused){
      System.out.println("Continuing video: " + pausedVideo.getTitle());
      isPaused = false;
    }
    else if (!isPlaying){
      System.out.println("Cannot continue video: No video is currently playing");
    }
    else {
      System.out.println("Cannot continue video: Video is not paused");
    }
  }

  public void showPlaying() {
    // An attempt to change format of "-PAUSED"
    // Still failed the test as they didn't want it as a string
    String paused = " - PAUSED";
    if (isPlaying && !isPaused){
      System.out.println("Currently playing: " + nowPlaying.getTitle() + " (" + nowPlaying.getVideoId()
              + ") " + nowPlaying.getTags().toString().replaceAll("," , ""));
    }
    else if (isPaused){
      System.out.println("Currently playing: " + nowPlaying.getTitle() + " (" + nowPlaying.getVideoId()
              + ") " + nowPlaying.getTags().toString().replaceAll(",","") + paused);
    }
    else {
      System.out.println("No video is currently playing");
    }
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}