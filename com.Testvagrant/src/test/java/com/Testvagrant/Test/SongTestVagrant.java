package com.Testvagrant.Test;

import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class SongTestVagrant {
	    private int initialCapacity;
	    private Map<String, LinkedList<String>> datastore;

	    public SongTestVagrant(int initialCapacity) {
	        this.initialCapacity = initialCapacity;
	        this.datastore = new HashMap<>();
	    }

	    public void addSong(String user, String song) {
	        if (!datastore.containsKey(user)) {
	        	datastore.put(user, new LinkedList<>());
	        } else if (datastore.get(user).contains(song)) {
	        	datastore.get(user).remove(song);
	        }

	        LinkedList<String> userPlaylist = datastore.get(user);
	        if (userPlaylist.size() >= initialCapacity) {
	            userPlaylist.removeFirst();
	        }

	        userPlaylist.add(song);
	    }

	    public LinkedList<String> getRecentlyPlayed(String user) {
	        return datastore.getOrDefault(user, new LinkedList<>());
	    }
	


	public static void main(String[] args) {
		SongTestVagrant songStore = new SongTestVagrant(3);

        songStore.addSong("user1", "S1");
        songStore.addSong("user1", "S2");
        songStore.addSong("user1", "S3");

        System.out.println(songStore.getRecentlyPlayed("user1")); 

        songStore.addSong("user1", "S4");

        System.out.println(songStore.getRecentlyPlayed("user1")); 
        songStore.addSong("user1", "S2");
        
        System.out.println(songStore.getRecentlyPlayed("user1"));
        songStore.addSong("user1", "S1");

        System.out.println(songStore.getRecentlyPlayed("user1")); 
    }
	}

