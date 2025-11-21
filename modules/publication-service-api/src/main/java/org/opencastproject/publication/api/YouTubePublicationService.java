/*
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 *
 * The Apereo Foundation licenses this file to you under the Educational
 * Community License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License
 * at:
 *
 *   http://opensource.org/licenses/ecl2.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package org.opencastproject.publication.api;

import org.opencastproject.job.api.Job;
import org.opencastproject.mediapackage.MediaPackage;
import org.opencastproject.mediapackage.Track;

import com.google.api.services.youtube.model.Playlist;

/**
 * Publishes elements from MediaPackages to youtube.
 */
public interface YouTubePublicationService {

  /**
   * Identifier for service registration and location
   */
  String JOB_TYPE = "org.opencastproject.publication.youtube";

  /**
   * Publishes a media package element.
   *
   * @param mediaPackage
   *          the media package
   * @param track
   *          the track of the media package to publish
   * @return The job
   * @throws PublicationException
   *           if there was a problem publishing the media
   */
  Job publish(MediaPackage mediaPackage, Track track) throws PublicationException;

  /**
   * Publishes a media package element.
   *
   * @param mediaPackage
   *          the media package
   * @param track
   *          the track of the media package to publish
   * @param useOpencastPlaylists
   *          if Opencast Playlists should be considered
   * @return The job
   * @throws PublicationException
   *           if there was a problem publishing the media
   */
  Job publish(MediaPackage mediaPackage, Track track, boolean useOpencastPlaylists) throws PublicationException;

  /**
   * Publishes an Opencast Playlist.
   *
   * @param opencastPlaylistId
   *          the media package
   * @throws PublicationException
   *           if there was a problem publishing the media
   */
  void publishOpencastPlaylist(String opencastPlaylistId) throws PublicationException;

  /**
   * Retract a media package element from the distribution channel.
   *
   * @param mediaPackage
   *          the media package
   * @throws PublicationException
   *           if there was a problem retracting the mediapackage
   */
  Job retract(MediaPackage mediaPackage) throws PublicationException;

  /**
   * Creates a playlist.
   *
   * @param title
   *          the playlist title
   * @param description
   *          the playlist description
   * @param tags
   *          comma separate list of tags
   * @return state
   * @throws PublicationException
   *           if there was a problem creating the playlist
   */
  Playlist createPlaylist(String title, String description, String... tags) throws PublicationException;

  /**
   * Deletes a playlist by its title.
   *
   * @param title
   *          the playlist title
   * @throws PublicationException
   *           if there was a problem creating the playlist
   */
  void deletePlaylistByTitle(String title) throws PublicationException;

  /**
   * Deletes a playlist by its ID.
   *
   * @param playlistID
   *          the playlist title
   * @throws PublicationException
   *           if there was a problem creating the playlist
   */
  void deletePlaylistByID(String playlistID) throws PublicationException;
}
