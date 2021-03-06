---
layout: page
title: Changelog
bigimg: /images/changelog.jpg
---

<div id="home">

Please note: There might be also a newer beta version available. To register for beta version, make sure to join the andFHEM Google+ group
and register on one of the following pages below (for your installed version):

<ul>
<li><a href="https://play.google.com/apps/testing/li.klass.fhem">Inapp / Default</a></li>
<li><a href="https://play.google.com/apps/testing/li.klass.fhempremium">Premium (as separate app)</a></li>
</ul>

{% for release in site.github.releases %}
<h3><a href="https://github.com/klassm/andFHEM/milestones/{{release.name}}">{{release.name}}</a> ({{release.published_at | date: '%d.%m.%Y'}})</h3>
<div markdown="1">{{release.body}}</div>
{% endfor %}

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.9">4.7.9</a> (25.11.2017)</h3>
    <div>
        <ul>
            <li>More widget changes:
                <ul>
                    <li>In some cases widget configurations remain within andFHEM even though they
                        don't exist any more. AndFHEM still tries to update them, loads the device
                        list and tries
                        to update a device that cannot be found. This consumes loads of battery and
                        is useless,
                        which is why this behaviour changed in 4.7.9.
                    </li>
                    <li>When updating a single widget fails, all other widgets will still be updated
                        by now
                    </li>
                </ul>
            </li>
            <li>Migrate more devices as generic devices: (15 device types still left to be migrated
                ...)
                <ul>
                    <li>TRX_LIGHT</li>
                    <li>STV</li>
                    <li>EIB</li>
                    <li>PID/PID20</li>
                    <li>EC3000</li>
                    <li>EnOcean</li>
                    <li>LGTV</li>
                    <li>ENIGMA2</li>
                    <li>SOMFY</li>
                    <li>SWAP</li>
                    <li>OWTHERM</li>
                    <li>DMX</li>
                    <li>ReadingsProxy</li>
                    <li>WiFiLight</li>
                </ul>
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.8">4.7.8</a> (19.11.2017)</h3>
    <div>
        <ul>
            <li>Repair timer creating (did not save when creating a new one)</li>
            <li>Migrate MiLight and Threshold devices as generic devices</li>
            <li>Add hook for an alias name evaluated only in andFHEM</li>
            <li>Allow two lines in status appwidget</li>
            <li>Rewrite appwidget updating - this should improve battery behaviour and result in
                more reliable updates
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.7">4.7.7</a> (13.11.2017)</h3>
    <div>
        <ul>
            <li>Evaluate FHEMWEB column attribute</li>
            <li>Repair hiddengroup FHEMWEB attribute</li>
            <li>FCM notification history now keeps data only a limited (configurable) timespan<br/>
                - this is a breaking change, all existing data is deleted on update.
            </li>
            <li>Remove voice commands <br/> The implementation violated Google's terms of use, as
                accessibility services may only be used to help disabled people.
            </li>
            <li>Migrate settings to Google's new API</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.6">4.7.6</a> (05.11.2017)</h3>
    <div>
        <ul>
            <li>Repair off by one error for months in FCM notification history</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.5">4.7.5</a> (30.10.2017)</h3>
    <div>
        <ul>
            <li>Repair application crash for LightScene device without scenes</li>
            <li>Retry sending commands when csrf connections fails with handshake errors or
                connection timeouts
            </li>
            <li>Repair high Battery Usage on "Remote Widget Refresh"</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.4">4.7.4</a> (22.10.2017)</h3>
    <div>
        <ul>
            <li>Enable temperature widget for Lacrosse devices</li>
            <li>Add GCM/FCM notification history<br/>
                This is a premium only feature, as this does not represent a "normal" use case
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.3">4.7.3</a> (07.10.2017)</h3>
    <div>
        <ul>
            <li>Show graphs buttons also directly in SVG device details</li>
            <li>Use custom sender-id to register for GCM/FCM notifications. This is required for
                newly registering devices (or you won't ever receive any notifications)
            </li>
            <li>Check after app update whether device list has been corrupted (this happens when I
                change the internal data structure). Reload data then.
            </li>
            <li>Repair 1x1 app widget</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.2">4.7.2</a> (03.10.2017)</h3>
    <div>
        <ul>
            <li>Repair setup of new FCM/GCM connections</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.1">4.7.1</a> (30.09.2017)</h3>
    <div>
        <ul>
            <li>Fix Tasker send command plugin</li>
            <li>Add suggestions to search view</li>
            <li>Update number of columns directly after changing the column widthpreference</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.7.0">4.7.0</a> (24.09.2017)</h3>
    <div>
        <ul>
            <li>Migrate API from GCM to FCM<br/>
                As GCM has been deprecated by Google, andFHEM has now migrated to the new API. This
                has some consequences:
                <ul>
                    <li>All currently configured gcm preferences will stop to work. Sorry for that
                        ...
                    </li>
                    <li>You will have to update the 98_gcmsend plugin by using the version <a
                            href="https://raw.githubusercontent.com/klassm/andFHEM/master/fhem_modules/98_gcmsend.pm">here</a>
                    </li>
                    <li>Re-register all devices to receive FCM notifications</li>
                </ul>
            </li>

            <li>Add searching for devices</li>
            <li>Migrate dummy device as generic device</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.9">4.6.9</a> (17.09.2017)</h3>
    <div>
        <ul>
            <li>Fix issue when loading device list from FHEMWEB without having a username or
                password configured
            </li>
            <li>Fix issues concerning Android Oreo (especially notifications related to self-signed
                certificates and gcm)
            </li>
            <li>Fix issue when changing server connections, as view was not changed to reflect the
                changed server
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.8">4.6.8</a> (03.09.2017)</h3>
    <div>
        <ul>
            <li>When updating or creating connections on tablets, detail view won't disappear</li>
            <li>Handle device state containing html</li>
            <li>Updates for Android 26 (Oreo)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.7">4.6.7</a> (20.08.2017)</h3>
    <div>
        <ul>
            <li>Add password protection also when returning to the main app from a widget.</li>
            <li>Repair widget update when having different servers configured</li>
            <li>Repair application crash for devices containing on/off in groups within a setlist
            </li>
            <li><span style="color:red;font-weight:bold">IMPORTANT: </span>Speech recognition only
                for for Google Now. As Google Now is deprecated and is being replaced by Goggle
                Assistant, speech recognition will stop to work. <br/>
                Up to now, there is no workaround for this issue, as the official API for Google
                Assistant requires a central server to be called (which we do not have for FHEM).
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.6">4.6.6</a> (13.08.2017)</h3>
    <div>
        <ul>
            <li>Improve widget battery usage</li>
            <li>Make device name make use of the rest of the space in device overview</li>
            <li>Limit button space to max 50% for device list overview and webcmd</li>
            <li>Repaird device rotation leading to empty view in room device list</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.5">4.6.5</a> (06.08.2017)</h3>
    <div>
        <ul>
            <li>Fix issue in toggle widgets when on state name cannot be found</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.4">4.6.4</a> (04.08.2017)</h3>
    <div>
        <ul>
            <li>Widget update bug finally fixed.</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.3">4.6.3</a> (01.08.2017)</h3>
    <div>
        <ul>
            <li>Fix application crash for devices with hooks not containing a "OFF" or "off" within
                the setList
            </li>
            <li>Fix retry command view: Clicking the button did not retry the last failed command
            </li>
            <li>Fix wrong username or password not being displayed as error</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.2">4.6.2</a> (30.07.2017)</h3>
    <div>
        <ul>
            <li>Fix display of toggle and on-off buttons for dummy devices</li>
            <li>Repair issue crashing widget update service, resulting in error widget views</li>
            <li>Evaluate devStateIcons for device states and attributes (only for textual
                attributes, not for on/off buttons or sliders).<br/>
                As this feature has nothing to do with basic application functionality, this feature
                is only available to Premium users.
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.1">4.6.1</a> (15.07.2017)</h3>
    <div>
        <ul>
            <li>Better support for MQTT devices</li>
            <li>Bugfix: Device name list should have only one column in navigation</li>
            <li>Bugfix: Devices in room "hidden" are shown in all devices</li>
            <li>Bugfix: SORTBY attribute ignored</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.6.0">4.6.0</a> (10.07.2017)</h3>
    <div>
        <ul>
            <li>Bugfix: Repair viewing of connection details, floorplan and timer settings</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.9">4.5.9</a> (09.07.2017)</h3>
    <div>
        <ul>
            <li>Update device list layout: Move self-written layout (GridView) to Android standard
                layout (RecyclerView with Staggered Layout). <b>Implications</b>:
                <ul>
                    <li>First of all, this should resolve some (very) long standing issues.
                        Especially, when opening the app after some time, the device list was shown
                        as empty (no devices found). This bug should be just fixed with the new
                        infrastructure.
                    </li>
                    <li>The staggered view also means that when using multiple columns, especially
                        for tablets, rows of different columns are no longer aligned. The columns
                        are layouted completely separately. In effect, this uses much more of the
                        available space.
                    </li>
                    <li>However, this also means that there is no longer a grid - thus it is
                        difficult to find out which attributes of each row belong to each other.
                        Android has introduced cards to treat that issue. This is exactly what
                        AndFHEM does now. However, <b>this is a design experiment</b>, so if you
                        don't like it, feel free to send me a message, together with a hint on how
                        to solve this issue in a better way.
                    </li>
                    <li>Previously it was possible to specify column sizes within the preferences.
                        This option is gone by now. AndFHEM will calculate a "good" column width for
                        you. However, if this does not work on your device, please tell me.
                    </li>
                </ul>
            </li>
            <li>Migrate PCA9532 and PCF8574 as generic devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.8">4.5.8</a> (02.07.2017)</h3>
    <div>
        <ul>
            <li>HM485 as generic device</li>
            <li>Remove misleading message for on-for-timer switching</li>
            <li>Add Google Inapp Search</li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.7">4.5.7</a> (10.06.2017)</h3>
    <div>
        <ul>
            <li>Repair crash on opening timetable for CUL_HM devices</li>
            <li>Delay refresh when switching EspEasy devices</li>
            <li>Repair SetList parsing for setLists containing colons (:)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.6">4.5.6</a> (04.06.2017)</h3>
    <div>
        <ul>
            <li>Handle slider values with 0.01 steps</li>
            <li>Switch event map states by using the event map value instead of finding the
                associated key (if the mapping is not unique, this solution is much more stable)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.5">4.5.5</a> (29.05.2017)</h3>
    <div>
        <ul>
            <li>Don't crash on floating point steps (however, those do not correctly behave within
                andFHEM)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.4">4.5.4</a> (28.05.2017)</h3>
    <div>
        <ul>
            <li>Show device name when editing timetable / heating schedules</li>
            <li>Slider set list selector does not cut ".0" values, resulting in wrong FHEM
                commands
            </li>
            <li>Access graphs with offset of server time, not client time</li>
            <li>Migrate CUL_FHTTK to generic device</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.3">4.5.3</a> (30.04.2017)</h3>
    <div>
        <ul>
            <li>User CAs are by default trusted (this changed in Android N)</li>
            <li>When adding a first connection and pressing refresh, only dummy data was loaded</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.2">4.5.2</a> (22.04.2017)</h3>
    <div>
        <ul>
            <li>Fix application crash when selecting app update times in preferences</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.1">4.5.1</a> (09.04.2017)</h3>
    <div>
        <ul>
            <li>Migrate file picker to external library (export import and client cert)</li>
            <li>Repair Floorplan switching (csrf token)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.5.0">4.5.0</a> (03.04.2017)</h3>
    <div>
        <ul>
            <li>Correctly parse .* regexp for graphs (relevant for DBlog ...)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.9">4.4.9</a> (02.04.2017)</h3>
    <div>
        <ul>
            <li>More logs for graph / gplot loading</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.8">4.4.8</a> (26.03.2017)</h3>
    <div>
        <ul>
            <li>Load device graphs asynchronously (so that the device detail page does not appear
                that sluggish)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.7">4.4.7</a> (18.03.2017)</h3>
    <div>
        <ul>
            <li>Load device graph definitions when opening the device detail page instead when
                loading the xmllist. Please make sure
                to update the device list from within the "Favorites", "Rooms" or "All devices" view
                to be sure all graphs
                are shown correctly
            </li>
            <li>Handle colorpicker setList attributes not referencing RGB as normal sliders</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.6">4.4.6</a> (12.03.2017)</h3>
    <div>
        <ul>
            <li>Load graphs using a given server connection (making graph viewing from widgets
                possible)
            </li>
            <li>Adapt translation for Revolt devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.4">4.4.4</a> (05.03.2017)</h3>
    <div>
        <ul>
            <li>Show long GCM content in a bigger notification box (thanks @Jens)</li>
            <li>Refresh widgets only one when sending a command.</li>
            <li>Open the correct device form another connection when clicking on the respective
                widget
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.3">4.4.3</a> (25.02.2017)</h3>
    <div>
        <ul>
            <li>Support FHEM csrf token.</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.2">4.4.2</a> (19.02.2017)</h3>
    <div>
        <ul>
            <li>CO20 widget for voc state</li>
            <li>Error logs should be read in UTF-8 (making logs more plausible ...)</li>
            <li>Webcmd buttons are missing for generic devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.1">4.4.1</a> (11.02.2017)</h3>
    <div>
        <ul>
            <li>When switching devices update internal device state using the new value (to avoid
                blinking device states for on/off devices)
            </li>
            <li>Update Memorizing Trust Manager for self signed certificates</li>
            <li>Update infrastructure to load device lists from FHEMWEB</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.4.0">4.4.0</a> (05.02.2017)</h3>
    <div>
        <ul>
            <li>Always parse xmllists (and return values from FHEMWEB) using UTF-8 as fixed encoding<br/>This
                might explain some xmllist load / parse errors.
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.9">4.3.9</a> (30.01.2017)</h3>
    <div>
        <ul>
            <li>Remove outdated device information marker in room list</li>
            <li>Show humidity in Oregon temperature widget</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.8">4.3.8</a> (29.01.2017)</h3>
    <div>
        <ul>
            <li>Bugfix: When using multiple servers widgets updated using only the currently
                selected server
            </li>
            <li>Widgets updates only update their own xmllist, reducing the update time and amount
                of data
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.7">4.3.7</a> (28.01.2017)</h3>
    <div>
        <ul>
            <li>Bugfix: Syntax error popup shows up when showing floorplans (only most recent
                floorplan version)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.6">4.3.6</a> (21.01.2017)</h3>
    <div>
        <ul>
            <li>Enable webview hook also for non toggleable devices</li>
            <li>Repair l4 color in gplots</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.5">4.3.5</a> (16.01.2017)</h3>
    <div>
        <ul>
            <li>Migrate ONKYO_AVR as generic device, fixing some bugs</li>
            <li>Add preference option to enable remote update of a room when opening it</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.4">4.3.4</a> (06.01.2017)</h3>
    <div>
        <ul>
            <li>On-for-timer time can now also be seconds (not only minutes and hours)</li>
            <li>Repair duplicate install error dialog - andFHEM Premium and andFHEM may not be
                installed both at the same time on the same device, as those two versions will
                conflict.
            </li>
            <li>Repair parse KNX device list error</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.3">4.3.3</a> (31.12.2016)</h3>
    <div>
        <ul>
            <li>Bugfix: Copied day profiles cannot be saved</li>
            <li>Bugfix: Change slider value via "set" button (can be enabled in preferences) does
                not work for floating point values
            </li>
            <li>Bugfix: SetList slider type accepts four values (whereas the fourth one is always a
                one). AndFHEM will accept the parameter, but ignore it
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.2">4.3.2</a> (26.12.2016)</h3>
    <div>
        <ul>
            <li>Repair problem with device list loading when setList attribute has no value</li>
            <li>Repair connection list opening (when not having configured a connection the
                management view cannot be opened)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.1">4.3.1</a> (10.12.2016)</h3>
    <div>
        <ul>
            <li>Copy weekprofile heating data from other days (for FHT, MAX, CUL_HM)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.3.0">4.3.0</a> (26.11.2016)</h3>
    <div>
        <ul>
            <li>Hotfix: Connection list cannot be opened</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.9">4.2.9</a> (26.11.2016)</h3>
    <div>
        <ul>
            <li>Device list update does not remove deleted devices</li>
            <li>Multiple line webCmd buttons are hidden</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.8">4.2.8</a> (25.11.2016)</h3>
    <div>
        <ul>
            <li>Don't crash when encountering invalid hex strings in RGB attributes</li>
            <li>Ignore special characters (space, !, ?, _) for spoken commands (to match more
                devices
            </li>
            <li>When switching from widgets update device data from the respective connection. (This
                is only important if you have multiple servers configured)
            </li>
            <li>Repair FHT timetable editing</li>
            <li>Hide dummy connections when at least one real connection has been configured</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.7">4.2.7</a> (06.11.2016)</h3>
    <div>
        <ul>
            <li>Use SetList when defining new timers</li>
            <li>Close sidebar drawer on connection change</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.6">4.2.6</a> (05.11.2016)</h3>
    <div>
        <ul>
            <li>Bugfix: Fix endless device list loading when encountering a connection error</li>
            <li>Bugfix: Also consider favorites from different connections when exporting and
                importing backups
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.5">4.2.5</a> (30.10.2016)</h3>
    <div>
        <ul>
            <li>Bugfix: Fix endless device list loading (handle null cache)</li>
            <li>Bugfix: Ask for file system permissions for export and import</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.4">4.2.4</a> (29.10.2016)</h3>
    <div>
        <ul>
            <li>Repair delayed room (and device update)</li>
            <li>Set client certificate and https settings directly before switching (those settings
                are global,
                interleaved commands would overwrite those settings)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.3">4.2.3</a> (25.10.2016)</h3>
    <div>
        <ul>
            <li>Resolve performance bootleneck when switching views</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.2">4.2.2</a> (23.10.2016)</h3>
    <div>
        <ul>
            <li>If using multiple connections andFHEM will now store favorites and widgets for each
                of those connections. In effect, you can now execute widget commands without
                changing the connection within andFHEM. Note: AndFHEM will only migrate existing
                favorites if only one connection is available. Note2: This is a pretty huge change.
                I've tried to test those "few" available features to my very best. If you still
                encounter some bugs, please feel free to write a mail or open a Github issue.
                Thanks!
            </li>
            <li>Delay HUE commands (just like CUL_HM) to see whether andFHEM will update the status
                correctly afterwards
            </li>
            <li>Enable colorpicker for ECMD devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.1">4.2.1</a> (16.10.2016)</h3>
    <div>
        <ul>
            <li>Repair Timer integration to work with more recent versions of the AT module</li>
            <li>Execute device update after issueing a command to 2s (so that FHEM has some time to
                get an ACK of the device)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.2.0">4.2.0</a> (08.10.2016)</h3>
    <div>
        <ul>
            <li>Additional attributes for ZWave devices (battery and alarm)</li>
            <li>Fix "scroll-up" in timetable view</li>
            <li>Fix FS20 dim states (wrong order, as 100% is not a successor of 06%)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.9">4.1.9</a> (02.10.2016)</h3>
    <div>
        <ul>
            <li>Bugfix: andFHEM does not send subStates (consequently i.e. CUL_HM desired-temp and
                controlMode are broken)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.8">4.1.8</a> (25.09.2016)</h3>
    <div>
        <ul>
            <li>Migrate HUE as generic device, support more types of HUE devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.7">4.1.7</a> (18.09.2016)</h3>
    <div>
        <ul>
            <li>Repair OWSWITCH output commands</li>
            <li>Repair on-for-timer and off-for-timer commands (wrong by a factor of 60)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.6">4.1.6</a> (11.09.2016)</h3>
    <div>
        <ul>
            <li>Fix application crash when clicking webcmd buttons whose states are not contained in
                the setList
            </li>
            <li>Show graphs directly in SVG devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.5">4.1.5</a> (04.09.2016)</h3>
    <div>
        <ul>
            <li>on-for-timer also shows a time picker dialog. This is much easier to use, but also
                prevents use from
                picking seconds. Please give me a hint if this is a problem for you.
            </li>
            <li>Provide a new version of gcmsend enabling AES encryption. Please make sure to update
                your local device
                list after setting an encryption key. AndFHEM picks the key from the local device
                list.
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.4">4.1.4</a> (25.08.2016)</h3>
    <div>
        <ul>
            <li>Show more buttons for OWSWITCH (F-H)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.3">4.1.3</a> (14.08.2016)</h3>
    <div>
        <ul>
            <li>Adapt logging for debugging missing dblog graphs</li>
            <li>Show more states for OWSWITCH devices (A-F)</li>
            <li>Support configDB for graphs</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.2">4.1.2</a> (31.07.2016)</h3>
    <div>
        <ul>
            <li>Repair preferences export and import for pre Android 4.1.1 devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.1">4.1.1</a> (17.07.2016)</h3>
    <div>
        <ul>
            <li>Allow IMATIC switching (why standards, you can also use 0 as off and 1 as on ...)
            </li>
            <li>Repair tablet device scroll behavior in navigation fragment (left)</li>
            <li>Partial room / device list updates no longer lose graphs</li>
            <li>Repair table device xmllist update (completed instantly)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.1.0">4.1.0</a> (09.07.2016)</h3>
    <div>
        <ul>
            <li>Proper support for stepped line charts</li>
            <li>Bring back update icon (swipe to refresh still works)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.9">4.0.9</a> (05.06.2016)</h3>
    <div>
        <ul>
            <li>Refresh only a single room when pulling down the device list in a single room</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.8">4.0.8</a> (26.05.2016)</h3>
    <div>
        <ul>
            <li>Webcmd devices can make andFHEM crash on large devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.7">4.0.7</a> (22.05.2016)</h3>
    <div>
        <ul>
            <li>Clicking the inapp billing button produced an application crash</li>
            <li>State values with dim prefix resulted in wrong slider position</li>
            <li>EditActivity for Tasker plugin could crash when calling intent is not completely
                filled
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.6">4.0.6</a> (14.05.2016)</h3>
    <div>
        <ul>
            <li>Disable swipe to update in floorplan</li>
            <li>More space for webcmd buttons in overview (to get them on one line</li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.5">4.0.5</a> (07.05.2016)</h3>
    <div>
        <ul>
            <li>thanks @maniac103: Swipe to refresh (pull down to update the device list), update
                buttons removed
            </li>
            <li>thanks @maniac103: Connection spinner in navbar</li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.4">4.0.4</a> (30.04.2016)</h3>
    <div>
        <ul>
            <li>Reload device xmllist when sending commands</li>
            <li>Repair styling of widget selection tabs</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.3">4.0.3</a> (23.04.2016)</h3>
    <div>
        <ul>
            <li>Support OK, google commands for devices with more than one word (only via
                pronunciation hook!)
            </li>
            <li>Make Openweathermap device generic</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.2">4.0.2</a> (16.04.2016)</h3>
    <div>
        <ul>
            <li>Support heating widget for CUL_HM devices</li>
            <li>Clicking the refesh button within the device detail view now refreshed only the
                specific device
            </li>
            <li>Command history now supports deleting / editing commands. Pressing commands does not
                add them again to
                the recent commands list. Please note: the update will remove all your current
                recent commands.
            </li>
            <li>Bugfix: Renaming devices makes them disappear from favorites</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.1">4.0.1</a> (02.04.2016)</h3>
    <div>
        <ul>
            <li>Adapt layout for webview buttons in overview</li>
            <li>Add support for multi window functionality for Samsung devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/4.0.0">4.0.0</a> (27.03.2016)</h3>
    <div>
        <ul>
            <li>Read name and alias attributes only from INTERNALS and ATTRIBUTES, so that names
                cannot clash
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.9">3.9.9</a> (20.03.2016)</h3>
    <div>
        <ul>
            <li>Repair telnet connection</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.8">3.9.8</a> (06.03.2016)</h3>
    <div>
        <ul>
            <li>Time picker values were not used when changing values manually</li>
            <li>Add certificate checking for web links</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.7">3.9.7</a> (28.02.2016)</h3>
    <div>
        <ul>
            <li>Repair YAMAHA_AVR mute button / migrate device to generic device infrastructure</li>
            <li>Repair on/off substate button for generic devices in detail view</li>
            <li>Repair target state widget</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.6">3.9.6</a> (20.02.2016)</h3>
    <div>
        <ul>
            <li>MAX timer intervals may be divisble by 5</li>
            <li>Ask for additional set list information even if the set list does not ask for it
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.5">3.9.5</a> (14.02.2016)</h3>
    <div>
        <ul>
            <li>Consider set list modifiers</li>
            <li>Repair tasker plugin for querying conditions</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.4">3.9.4</a> (07.02.2016)</h3>
    <div>
        <ul>
            <li>Repair next alarm clock date string</li>
            <li>Allow weblink relative urls</li>
            <li>Allow uppercase ON/OFF for toggle rows</li>
            <li>Handle state changing spinner when selected value is not within setlist states</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.3">3.9.3</a> (31.01.2016)</h3>
    <div>
        <ul>
            <li>Add appwidget for JSONMETER (medium information)</li>
            <li>If a device "nextAlarmClock" is defined andFHEM will update its state with the next
                scheduled alarm
                clock (if present) every six hours
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.2">3.9.2</a> (29.01.2016)</h3>
    <div>
        <ul>
            <li>Repair actions for new style adapters (so that device actions are shown)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.1">3.9.1</a> (10.01.2016)</h3>
    <div>
        <ul>
            <li>Old style adapters could not attach field listerns, resulting in missing actions for
                devices
            </li>
            <li>Time detail generation only generated lowercase commands (wrong i.e. for
                desiredTemp)
            </li>
            <li>Use the next free color when parsing gplot files without color definition for
                series
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.9.0">3.9.0</a> (04.01.2016)</h3>
    <div>
        <ul>
            <li>Repair off state for EnOcean devices (defaulted to closes)</li>
            <li>Basic support for S7 devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.9">3.8.9</a> (25.12.2015)</h3>
    <div>
        <ul>
            <li>Support graphfunction attribute for device plots</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.8">3.8.8</a> (21.11.2015)</h3>
    <div>
        <ul>
            <li>Repair FHT 24:00 / 00:00 handling</li>
            <li>Repair MAX on/off temperature commands</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.7">3.8.7</a> (13.11.2015)</h3>
    <div>
        <ul>
            <li>Replace slider min max when setting heating values (issues with MAX)</li>
            <li>Repair sliders for MAX</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.6">3.8.6</a> (07.11.2015)</h3>
    <div>
        <ul>
            <li>Show CUL_HM state in overview</li>
            <li>Show MAX sliders for all temperature states except desired-temperature</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.5">3.8.5</a> (06.11.2015)</h3>
    <div>
        <ul>
            <li>Very basic support for HUE CT devices (what does CT stand for?)</li>
            <li>Show KeyMatic lock state in overview</li>
            <li>Repair various errors for andFHEM freezing</li>
            <li>Replace MAX sliders by spinners (just as the ones FHEMWEB uses)</li>
            <li>Add marker view to charts (clicking on a chart value produces a popup showing time
                and value)
            </li>
            <li>Repair device state updates for GCM</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.4">3.8.4</a> (31.10.2015)</h3>
    <div>
        <ul>
            <li>Always show state on state card</li>
            <li>Show MAX state in overview</li>
            <li>Show eventMap state on on/off widget</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.3">3.8.3</a> (30.10.2015)</h3>
    <div>
        <ul>
            <li>Add FHT sliders by default (especially for day-temp and night-temp)</li>
            <li>Migrate twilight device as generic device (incl. new detail view)</li>
            <li>Reenable temperature widget for MAX</li>
            <li>Repair detail view for tablet devices (caused application crash)</li>
            <li>Ignore &lt;/&gt; tags in device lists (FHEM now sends this kind of tag, which makes
                the whole xmllist
                invalid. This causes unreadable xmllist errors)
            </li>
            <li>Add webcmd buttons to the new detail view</li>
            <li>Add current state view to available target states slider switch action</li>
            <li>Repair sliders for MAX</li>
            <li>Repair widgets for CUL_HM</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.2">3.8.2</a> (30.10.2015)</h3>
    <div>
        <ul>
            <li>Resolve issues with sliders and spinners (incl. CUL_HM / MAX mode setting, wrong
                dummy slider states
                etc.)
            </li>
            <li>Add missing CUL_HM configuration</li>
            <li>Fix german minimum temperature string (thanks @BuZZ-dEE)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.8.1">3.8.1</a> (25.10.2015)</h3>
    <div>
        <ul>
            <li>Bugfix: Release beta ... with some bugs. Sorry for that ...</li>
            <li>Repair google now voice recognition</li>
        </ul>
    </div>

    <h3>3.8.0 beta1 (04.10.2015)</h3>
    <div>
        <p>This is an initial beta release for the new version relying totally on generic devices.
            Please note that not
            all devices have been migrated as generic by now. Some devices, incl. AVR, dummy and rgb
            devices are still
            missing. However, the big ones (like HomeMatic, FS20, FHT, ...) are done.</p>
        <p>To test the beta release please see the information within the <a
                href="https://plus.google.com/communities/109065806053127368354">Google Plus
            Community</a>.</p>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.6.6">3.6.6</a> (04.10.2015)</h3>
    <div>
        <ul>
            <li>Bugfix: Floorplan also uses alternate url when not being able to load the
                floorplan
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.6.6">3.6.6</a> (04.10.2015)</h3>
    <div>
        <ul>
            <li>Bugfix: Floorplan also uses alternate url when not being able to load the
                floorplan
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.6.5">3.6.5</a> (23.08.2015)</h3>
    <div>
        <ul>
            <li>Bugfix: Ranges in charts finally working</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.6.4">3.6.4</a> (09.08.2015)</h3>
    <div>
        <ul>
            <li>Bugfix: Charts don't show negative y-axis values, ranges are not considered</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.6.3">3.6.3</a> (01.08.2015)</h3>
    <div>
        <ul>
            <li>Send password for alternative URL in weblinks</li>
            <li>Resolve issues with connection saving</li>
            <li>Disable appwidgets if an application startup password has been set</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.6.2">3.6.2</a> (26.07.2015)</h3>
    <div>
        <ul>
            <li>Bugfix: Hiding a device in a specific room should not hide it in all rooms</li>
            <li>Bugfix: Fix gplot parsing for some custom gplot files</li>
            <li>Improvement for premium recongnition, to not call Google Play that often</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.6.1">3.6.1</a> (11.07.2015)</h3>
    <div>
        <ul>
            <li>Bugfix: Fix issue concerning inapp billing</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.6.0">3.6.0</a> (04.07.2015)</h3>
    <div>
        <ul>
            <li>Bugfix: CUL_FHTTK state missing in overview</li>
            <li>Bugfix: FHT weekprofile data is missing</li>
            <li>Bugfix: group attributes are used no matter whether the attribute is an internal
                attribute or a real
                attribute, resulting in overlaps for EIB devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.5.9">3.5.9</a> (06.06.2015)</h3>
    <div>
        <ul>
            <li>Repair xmllist parse error (-nan is not a floating point number...)</li>
            <li>Graphs spanning multiple months showed "interesting" results upon month changes</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.5.8">3.5.8</a> (04.06.2015)</h3>
    <div>
        <ul>
            <li>Repair widget selection</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.5.6">3.5.6</a> (31.05.2015)</h3>
    <div>
        <ul>
            <li>Repair generic device functionality (always shown as dummy for non toggle/dimmable
                devices
            </li>
            <li>Add fix for more recent SSL versions</li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.5.5">3.5.5</a> (25.05.2015)</h3>
    <div>
        <ul>
            <li>Repair missing state in overview</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.5.4">3.5.4</a> (24.05.2015)</h3>
    <div>
        <ul>
            <li>Repair EnOcean state handling</li>
            <li>Repair xmllist parse error for some log devices</li>
            <li>Support for various ZWave devices</li>
            <li>Further transition of devices towards generic device, incl. better support for all
                generic devices
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.5.3">3.5.3</a> (16.05.2015)</h3>
    <div>
        <ul>
            <li>Case insensitive room list ordering</li>
            <li>Correct sorting of device groups for unknown devices</li>
            <li>Repair command execution for devices with "name" state attributes</li>
            <li>Repair MAX heating thermostat switch time layout issue</li>
            <li>And the big one - all graphs are replaced by reading the graph definition from GPlot
                files.
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.5.0">3.5.0/3.5.1</a> (25.04.2015)
    </h3>
    <div>
        <ul>
            <li>Bugfix: Toggle buttons are not shown for some devices/</li>
            <li>More devices migrated to "generic" ones (and more to come, incl. graphs from
                SVG/gplot definitions
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.5.0">3.5.0/3.5.1</a> (25.04.2015)
    </h3>
    <div>
        <ul>
            <li>Support for generic device
                <ul>
                    <li>All devices will show up (also devices that andFHEM doesn't know of)</li>
                    <li>Those attributes will contain name, definition, measured and all device
                        states
                    </li>
                    <li>Values will not be formatted but shown exactly like in FHEMWEB</li>
                </ul>
            </li>
            <li>Basic support for CUL_HM powerSensor (this is still work in progress)</li>
            <li>Voice command recongnition for in-app premium repaired</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.9">3.4.9</a> (18.04.2015)</h3>
    <div>
        <ul>
            <li>Be more graceful about xmllist again ... gnah FHEM, repair it!</li>
            <li>Don't show ENIGMA2 passwords</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.8">3.4.8</a> (12.04.2015)</h3>
    <div>
        <ul>
            <li>Repair always_hidden hook for FHEMWEB devices</li>
            <li>GPIO4 devices are now shown without limitiation to certain models</li>
            <li>More work towards generic devices - this will still take a while since it needs huge
                reimplementation...
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.7">3.4.7</a> (06.04.2015)</h3>
    <div>
        <ul>
            <li>Repair GCM status updates</li>
            <li>Alternative URL should be optional</li>
            <li>Fix issues with failed xmllist loading</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.6">3.4.6</a> (29.03.2015)</h3>
    <div>
        <ul>
            <li>Enable eventMap for webcmd</li>
            <li>Added support for remote / alternative url (thanks @JasonMask)</li>
            <li>Support HourCounter</li>
            <li>Support Harmony</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.5">3.4.5</a> (22.03.2015)</h3>
    <div>
        <ul>
            <li>Repair missing device switch options</li>
            <li>Send dim up/down only if max/min state has not already been reached</li>
            <li>Initial work on integration tests (to reduce future bugs ...)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.4">3.4.4</a> (15.03.2015)</h3>
    <div>
        <ul>
            <li>Support TCM97001</li>
            <li>Better defaults for device graphs</li>
            <li>Support PID20</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.3">3.4.3</a> (08.03.2015)</h3>
    <div>
        <ul>
            <li>Correct parsing of floating point numbers (state machines for the world!)</li>
            <li>Connection errors during application startup caused an endless loop preventing
                application startup
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.2">3.4.2</a> (03.03.2015)</h3>
    <div>
        <ul>
            <li>Fix connection saving</li>
            <li>Remove defaults for temperature device y-axis min and max values</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.1">3.4.1</a> (02.03.2015)</h3>
    <div>
        <ul>
            <li>Fix dummy data loading</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.4.0">3.4.0</a> (01.03.2015)</h3>
    <div>
        <ul>
            <li>Use port to determine FHEMWEB device (for hiddenrooms, ...)</li>
            <li>Solarview: show daily attributes</li>
            <li>Support MY_SENSORS</li>
            <li>Support CO20 devices</li>
            <li>Support PioneerAvrDevices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.9">3.3.9</a> (22.02.2015)</h3>
    <div>
        <ul>
            <li>Crash on application open by notification click</li>
            <li>Pseudo fix for Google Android TimePicker bug (DatePicker is not fixed yet, this is
                only relevant for FHT
                holiday mode
            </li>
            <li>Show FS20 on-for-timer as on and not as off</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.8">3.3.8</a> (07.02.2015)</h3>
    <div>
        <ul>
            <li>Don't show date when date is today</li>
            <li>Repair CUL_HM weekprofiles when containing multiple prefixes (P1, P2, ...)</li>
            <li>Add numeric MAX BOOST heating mode</li>
            <li>Changing temperatures back to the initial temperature produced no server request
            </li>
            <li>EnOcean device dimming sent wrong state</li>
            <li>Deactivate MAX timer edit (still this annoying Google bug...)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.7">3.3.7</a> (25.01.2015)</h3>
    <div>
        <ul>
            <li>Repair GCM updates for new device attributes</li>
            <li>Read numeric MAX control modes</li>
            <li>Repair Telnet connection editing</li>
            <li>Repair off-for-timer states not shown as off</li>
            <li>Support MiLight devices (dim / rgb)</li>
            <li>Support sortBy attribute for custom device order</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.6">3.3.6</a> (11.01.2015)</h3>
    <div>
        <ul>
            <li>Correct CUL_HM powerMeter attributes</li>
            <li>Refactor EnOcean device to use current dimmer infrastructure</li>
            <li>Add HM-LC-Bl1PBU-FM as shutter model for CUL_HM</li>
            <li>Support for HMS water detector</li>
            <li>Repair UI issue for webCmd and LightScene devices</li>
            <li>Export and import function to backup and restore your configuration</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.5">3.3.5</a> (04.01.2015)</h3>
    <div>
        <ul>
            <li>Empty device lists should still be used upon connection changes (but not when
                encountering errors)
            </li>
            <li>Repair HUE devices (changed subtype in new HUE FHEM modules</li>
            <li>Recognize EMCD device states properly</li>
            <li>Repair WebCmd action rows (showing all webcmds properly)</li>
            <li>Add a summary for all preferences / show the current preference state within the
                summary (as Google
                recommends)
            </li>
            <li>When returning from preferences devices could show up multiple times within device
                lists
            </li>
            <li>Recognize different levels s on (such as level*)</li>
            <li>Add support for FS20_ZDR channel programming (works only with the new FS20_ZDR
                module update)
            </li>
            <li>Allow "doch", "bitte", "please" as fill words for OK, google command recognition
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.4">3.3.4</a> (27.12.2014)</h3>
    <div>
        <ul>
            <li>EMCDDevice support</li>
            <li>HM-TC-IT-WM-W-EU support</li>
            <li>SolarView device support</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.3">3.3.3</a> (21.12.2014)</h3>
    <div>
        <ul>
            <li>Fix for wrong on/off button text</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.2">3.3.2</a> (20.12.2014)</h3>
    <div>
        <ul>
            <li>Smoother scrolling (thanks mamohr@github)</li>
            <li>Performance improvements for device list parsing (thanks mamohr@github)</li>
            <li>Unsafe certificates have to be explicitely accepted (thanks mamohr@github)</li>
            <li>Ok, google command sending (see <a href="voice_commands.html">manual</a> for
                details)
            </li>
            <li>Disable show password boxes in connection details when modifying a connection</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.1">3.3.1</a> (14.12.2014)</h3>
    <div>
        <ul>
            <li>Handle noArg entries in setLists (with influence on webCmd command sending!)</li>
            <li>Add ITrepetition attribute for PT2262 devices</li>
            <li>Add listeningMode for PioneerAvr devices</li>
            <li>Add visibility and windwhill to Weather devices</li>
            <li>Fix GCM updates containing multiple colons (especially state updates like H: 64 T:
                25)
            </li>
            <li>Fix application crash upon inapp billing initialization</li>
            <li>Use disable attribute to disable at timers</li>
            <li>Update to Android Studio 1.0 (thanks to mamohr)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.3.0">3.3.0</a> (07.12.2014)</h3>
    <div>
        <ul>
            <li>Support Pioneer-AVR, FHEMduino_ENV, FHEMduino_PT2262 devices</li>
            <li>Repair crash during timer device selection</li>
            <li>Repair application startup for non-Google account users (hopefully)</li>
            <li>Repair device list loading for large device lists (>1M)</li>
            <li>Send application log now uses attachments (enabling to send larger log files...)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.9">3.2.9</a> (28.11.2014)</h3>
    <div>
        <ul>
            <li>More verbose logging</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.8">3.2.8</a> (22.11.2014)</h3>
    <div>
        <ul>
            <li>Repair timer saving</li>
            <li>Support Enigma devices</li>
            <li>Repair notification settings for Lollipop</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.6">3.2.6 / 3.2.7</a> (16.11.2014)
    </h3>
    <div>
        <ul>
            <li>Support REVOLT devices</li>
            <li>Support ONKYO_AVR devices</li>
            <li>Better support for webcmd commands (opening windows when requiring additional
                information)
            </li>
            <li>Stability improvements</li>
            <li>Allow MAX temperature selection in timers</li>
            <li>Repair GCM registration in Lollipop</li>
            <li>Repair timer details</li>
            <li>Disable HOLIDAY and HOLIDAY_SHORT for FHT in Lollipop (until Google updates Android
                resolving <a
                        href="https://code.google.com/p/android/issues/detail?id=78984"
                        target="_blank">this</a> issue.)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.5">3.2.5</a> (09.11.2014)</h3>
    <div>
        <ul>
            <li>Repair CUL_HM / FHT weekprofile</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.4">3.2.4</a> (09.11.2014)</h3>
    <div>
        <ul>
            <li>Disallow external updates while editing CUL_HM / FHT timetables</li>
            <li>Repair switching FHT modes (Careful: HOLIDAY_SHORT and HOLIDAY still do not work in
                Lollipop)
            </li>
            <li>Infer OneWire group from device state</li>
            <li>Automatically load device list on initial application start</li>
            <li>Repair Tasker plugin in Lollipop</li>
            <li>Repair device functionality / group hiding</li>
            <li>Repair appwidget remote device list updates</li>
            <li>Repair display of the selected room within the room list (tablets only)</li>
            <li>Various styling issues (especially seekbar in Lollipop)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.3">3.2.3</a> (05.11.2014)</h3>
    <div>
        <ul>
            <li>Repair inapp premium version (@Singletons for the world....)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.2">3.2.2</a> (04.11.2014)</h3>
    <div>
        <ul>
            <li>Log messages</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.1">3.2.1</a> (03.11.2014)</h3>
    <div>
        <ul>
            <li>Repair Premium version</li>
            <li>Unset startup fragment does not result in empty view</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.2.0">3.2.0</a> (02.11.2014)</h3>
    <div>
        <ul>
            <li>Fix remote device list update for Lollipop</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.1.9">3.1.9</a> (02.11.2014)</h3>
    <div>
        <ul>
            <li>Fragments with navigation sidebar can cause application to not respond (This is a
                temporary workaround
                until Google fixes their libraries...)
            </li>
            <li>Startup screen showing what is currently loaded</li>
            <li>Device list loading improved (doing more in background, causing the application to
                be more stable
            </li>
            <li>Changes of connection details were not reflected in future remote device list
                updates
            </li>
            <li>Some styling issues (incl. white text color on white background (thanks HTC!))</li>
            <li>Fix for none existing Google Play Services (we still want to see the device list)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.1.6">3.1.6 / 3.1.7 / 3.1.8</a>
        (26.10.2014)</h3>
    <div>
        <ul>
            <li>Stop validating row numbers of remotecontrol devices</li>
            <li>Graphs for OWTHERM devices</li>
            <li>Repair CUL_FHTTK graphs</li>
            <li>Make use of sortRooms FHEMWEB property correctly (space as delimiter instead of
                comma, repair sort
                order)
            </li>
            <li>Preparations for Android 5
                <ul>
                    <li>Remove ActionBarSherlock as actionbar provider, make use of Google APIs</li>
                    <li>Compile against Android 5, allowing to install andFHEM on Android 5</li>
                    <li>Adapt styling to material design (at least a little bit, more to come).
                        Screenshots will be
                        updated when the styling update is finished. This will take some time as
                        Android 5 provides
                        loads of nice things.
                    </li>
                    <li><b>Important:</b> This has impact on pre Android 4 devices. Android 2.3
                        support has been
                        dropped. Android 2.3.3 is still supported, but I will not take too much care
                        on looks for now.
                        The market share concerning andFHEM is down to 5%, with drops of 2% expected
                        each month.
                        Effectively this means that Android 2.3.3 support will be dropped in about
                        three to four months.
                    </li>
                </ul>
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.1.5">3.1.5</a> (19.10.2014)</h3>
    <div>
        <ul>
            <li>Widget for switching devices on and off</li>
            <li>Bugfix: Repair target devices with dot in name (timer)</li>
            <li>Bugfix: Timer target device cannot be changed</li>
            <li>Various styling issues</li>
            <li>Graphs for THPL HomeMatic devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/milestones/3.1.4">3.1.4</a> (12.10.2014)</h3>
    <div>
        <ul>
            <li>Repair layout for FHT holiday short, FHT in general</li>
            <li>Repair target state widget</li>
            <li>Support SOMFY devices</li>
            <li>Handle OwDevices less restrictive, consequently support all OwDevice models</li>
            <li>Repair wrong offset in graph date month selection</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=155&page=1&state=closed">3.1.3</a>
        (15.09.2014)</h3>
    <div>
        <ul>
            <li>Improve application stability</li>
            <li>Graph for CUL_FHTTK</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=154&page=1&state=closed">3.1.2</a>
        (14.09.2014)</h3>
    <div>
        <ul>
            <li>Improve application stability</li>
            <li>Graphs vor SML_USB</li>
            <li>Show alias name (if present) in webcmd rows</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=152&page=1&state=closed">3.1.0 /
        3.1.1</a>
        (13.09.2014)</h3>
    <div>
        <ul>
            <li>Improve application stability</li>
            <li>Add permission definition for external api</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=151&page=1&state=closed">3.0.9</a>
        (09.09.2014)</h3>
    <div>
        <ul>
            <li>Bug: Try repair application not responding / crash on application start (careful: it
                is not certain that
                I completely removed the problem...)
            </li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=150&page=1&state=closed">3.0.8</a>
        (07.09.2014)</h3>
    <div>
        <ul>
            <li>Bug: Handle unset webcmds if webcmddevice hook is set</li>
            <li>Added graph time span for current day</li>
            <li>Support client certificates without passwords</li>
            <li>Support SMLUSB devices</li>
            <li>Support CUL_HM THPLSensor devices</li>
            <li>Various more bugfixes encountered during refactoring...</li>
            <li>Dev: Exported SendCommandService now requires permission:
                li.klass.fhem.permissions.SEND_COMMAND
            </li>
            <li>Dev: Exported ExternalApiService now requires permission:
                li.klass.fhem.permissions.EXTERNAL
            </li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=149&page=1&state=closed">3.0.7</a>
        (24.08.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: App won't open after resume.</li>
            <li>Add wind graph for THSensor Homematic devices.</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=148&page=1&state=closed">3.0.6</a>
        (23.08.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: Empty view showing on application resume</li>
            <li>Bugfix: Switch to telnet connection details not working</li>
            <li>Bugfix: Use certificates is always selected, making it impossible to create / edit
                non certificate
                connections
            </li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=147&page=1&state=closed">3.0.5</a>
        (17.08.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: App consuming too much power in endless loop (after some time...)</li>
            <li>Bugfix: WifiLight colour switching</li>
            <li>Bugfix: Don't show toggle buttons for CUL_HM powermeter devices without on and off
                in setList
            </li>
            <li>FHEMUP: Repair CUL_HM weekprofiles (now prefixes with R_0-9)</li>
            <li>Support multiple FileLog devices relating to only one device (important for
                withings)
            </li>
            <li>Support RoomMate devices</li>
            <li>Support NetAtmo devices</li>
            <li>Support client certificates</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=146&page=1&state=closed">3.0.4</a>
        (10.08.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: Executing indicator does not disappear when switching in detail view.</li>
            <li>Bugfix: Withings graphs</li>
            <li>Bugfix: Repair widget remote update (refresh even when in deep sleep.</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=145&page=1&state=closed">3.0.3</a>
        (03.08.2014)</h3>
    <div>
        <ul>
            <li>Unify behaviour of updating bars during xmllist update.</li>
            <li>Min/max values for custom graphs</li>
            <li>Support DMX devices</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=144&page=1&state=closed">3.0.2</a>
        (30.07.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: Temporary device list is not stored to disk</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=143&page=1&state=closed">3.0.1</a>
        (27.07.2014)</h3>
    <div>
        <ul>
            <li>Withings graph improvements</li>
            <li>Performance improvement for device view</li>
            <li>Configurable y-axis ranges for graphs. From now on there are some defaults for
                minimum and maximum
                y-axis ranges. If you find some completely invalid ranges, please tell me. For
                exotic use cases, you
                might want to read about the new yaxisminmax hook.
            </li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=140&page=1&state=closed">3.0.0</a>
        (20.07.2014)</h3>
    <div>
        <ul>
            <li>CUL_HM ignore parent subtype if child subtype is already set</li>
            <li>Withings support</li>
            <li>Another application crash fix</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=139&page=1&state=closed">2.9.9</a>
        (15.07.2014)</h3>
    <div>
        <ul>
            <li>In some cases toggl widgets break upon application update. This stems from an update
                within the andFHEM
                widget definition. If you still encounter this error please recreate the widget.
            </li>
            <li>Fix for ads showing in premium version.</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=138&page=1&state=closed">2.9.8</a>
        (14.07.2014)</h3>
    <div>
        <ul>
            <li>Fix application crash upon toggle widget click</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=137&page=1&state=closed">2.9.5</a>
        (06.07.2014)</h3>
    <div>
        <ul>
            <li>Upgrade to new Google Play Services (requirement of Google to upload new version,
                implies minimum
                Android version of 2.3)</li>
            <li>Race condition for license loading and showing of ads</li>
            <li>Floorplan fix for Android 4.4.4</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=136&page=1&state=closed">2.9.4</a>
        (29.06.2014)</h3>
    <div>
        <ul>
            <li>Bugfix (Application crash)</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=135&page=1&state=closed">2.9.4</a>
        (29.06.2014)</h3>
    <div>
        <ul>
            <li>Ability to send application log via mail (for better debugging)</li>
            <li>Update to new Android Studio (with all consequences ...)</li>
            <li>Fix application crash (occurring after some time)</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=133&page=1&state=closed">2.9.2</a>
        (24.06.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: Try to fix in-app-billing issue not recognizing devices as premium.</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=133&page=1&state=closed">2.8.9 -
        2.9.1</a>
        (21.06.2014)</h3>
    <div>
        <ul>
            <li>Support comma separated group attributes (for devices showing up in multiple
                groups)
            </li>
            <li>Do not reload the device list after preference close. This also includes updating
                the column width
                instantly.
            </li>
            <li>Consider empty application preferences as unset (important for FHEMWEB device
                options)
            </li>
            <li>Update Android-In-App billing library to version 3. The current version will be
                unsupported soon...
            </li>
            <li>Add password protection on application start.</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=132&page=1&state=closed">2.8.8</a>
        (08.06.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: Repair LightScene command</li>
            <li>Bugfix: Repair flowing buttons for webcmd</li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=131&page=1&state=closed">2.8.7</a>
        (29.05.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: Repair device selection for appwidgets.</li>
            <li>Bugfix: Repair device detail table showing all letters of a detail content below
                each other.
            </li>
        </ul>
    </div>

    <h3>
        <a href="https://github.com/klassm/andFHEM/issues?milestone=130&page=1&state=closed">2.8.6</a>
        (25.05.2014)</h3>
    <div>
        <ul>
            <li>Bugfix: Repair connection switching Locale plugin</li>
            <li>Bugfix: Repair floorplans without proper background images</li>
            <li>Use action bar for device actions (instead of the old fashioned context menu)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=129&page=1&state=closed"
           target="_blank">2.8.5</a>
        (17.05.2014)</h3>
    <div>
        <ul>
            <li>Finally working: Variable replacement for Tasker command sending.</li>
            <li>Support sortRooms attribute for FHEMWEB</li>
            <li>Bugfix: GCM message receiving for dedicated premium version</li>
            <li>Support EC3000 device</li>
            <li>Allow to select a FHEMWEB device whose attributes will be used for room hiding (<a
                    href="http://andfhem.klass.li/faq.html#deviceSpecificProperties">FAQ</a>). Also
                see hiddenroom in <a
                        href="http://fhem.de/commandref#FHEMWEB">FHEMWEB</a> for details.
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=128&state=closed"
           target="_blank">2.8.4</a>
        (04.05.2014)</h3>
    <div>
        <ul>
            <li>Allow setting of desired state for threshold devices</li>
            <li>Set HueDevice pct state instead of bri when dimming</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=127&page=1&state=closed"
           target="_blank">2.8.3</a>
        (03.05.2014)</h3>
    <div>
        <ul>
            <li>Variable replacement for send command plugin (Tasker only)</li>
            <li>Fix lightscene devices with only one scene</li>
            <li>Fix dewpoint graph color</li>
            <li>Support app deep linking (see <a
                    href="http://andfhem.klass.li/external_interfaces.html">External
                Interfaces URL scheme</a>) documentation
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=126&page=1&state=closed"
           target="_blank">2.8.2</a>
        (27.04.2014)</h3>
    <div>
        <ul>
            <li>Chart zoom buttons with a reasonable size (depending on screen size)</li>
            <li>KFM100 content view with a reasonable size (depending on screen size)</li>
            <li>Repair loading of some FileLog devices</li>
            <li>Dewpoint graph for CUL_WS</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=125&page=1&state=closed"
           target="_blank">2.8.1</a>
        (21.04.2014)</h3>
    <div>
        <ul>
            <li>Handle eventMaps in combination with is on calculating correctly</li>
            <li>WifiLight device support</li>
            <li>PCF8574 device support</li>
            <li>PCA9532 pwm0 and pwm1 sliders</li>
            <li>Set initial rgb color for swap devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=124&page=1&state=closed"
           target="_blank">2.8.0</a>
        (20.04.2014)</h3>
    <div>
        <ul>
            <li>Support threshold devices for timer creation</li>
            <li>Respect eventMap when determining whether a device is toggleable</li>
            <li>Respect FHEMWEB hiddenroom and hiddengroup devices</li>
            <li>Repair device selection (for timers and widgets)</li>
            <li>Sort custom device groups alphabetically (but below default groups)</li>
            <li>Remove duplicate CUL_HM state choice button</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=123&page=1&state=closed"
           target="_blank">2.7.9</a>
        (13.04.2014)</h3>
    <div>
        <ul>
            <li>Support for custom group attributes (always being sorted to the end of the device
                list)
            </li>
            <li>Support for PCA9532 devices</li>
            <li>Support for SHT21 devices</li>
            <li>Support for BMP180 devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=122&page=1&state=closed"
           target="_blank">2.7.8</a>
        (05.04.2014)</h3>
    <div>
        <ul>
            <li>RGB switching for SWAP devices</li>
            <li>Handle update on appliction start on every application resume</li>
            <li>CM160 device support.</li>
            <li>Repair GCM Premium permission, #2, now really...</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=121&page=1&state=closed"
           target="_blank">2.7.7</a>
        (22.03.2014)</h3>
    <div>
        <ul>
            <li>EGPM device support</li>
            <li>Fix supports toggle for dummy devices (which resulted in missing widgets)</li>
            <li>More time interval option for updating within the app</li>
            <li>Dropdown for available target states for various device types</li>
            <li>Hide empty rooms.</li>
            <li>Fix GCM for the standalone premium version.</li>
            <li>Fix substate switching in available target states.</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=120&page=1&state=closed"
           target="_blank">2.7.6</a>
        (17.03.2014)</h3>
    <div>
        <ul>
            <li>Fix several typos</li>
            <li>Fix substate switching in available target states switching</li>
            <li>Widget device list filtering influenced global device list, resulting in
                disappearing devices
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?labels=&milestone=119&page=1&state=closed"
           target="blank">2.7.5</a>
        (08.03.2014)</h3>

    <div>
        <ul>
            <li>Add ability to create a pure premium version (without inapp billing)</li>
            <li>Dim support for ReadingsProxy devices <br/>This also includes a major cleanup for
                all other dim devices.
                If one of your devices stopped working, please send me a current xmllist so I can
                resolve the error.
                Thanks!
            </li>
            <li>Handle setList correctly. FHEM sends some very nice information about which states
                are available for
                switching. Up to now andFHEM pretty much ignored that values. This is now evaluated
                correctly, resulting
                in a cleaner application design and, for all users, an updated available target
                states switching row.
            </li>
            <li>Support LightScene devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=118&page=1&state=closed"
           target="_blank">2.7.4</a>
        (02.03.2014)</h3>

    <div>
        <ul>
            <li>Bugfix: CUL_HM devices cannot be serialized (resulting in various errors)</li>
            <li>Bugfix: ReadingsProxy device may show RGB selector only if the device supports rgb
                switching
            </li>
            <li>Support HM485 devices</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=117&page=1&state=closed"
           target="_blank">2.7.3</a>
        (16.02.2014)</h3>

    <div>
        <ul>
            <li>Bugfix: Cannot read xmllist</li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=116&page=1&state=closed"
           target="_blank">2.7.2</a>
        (15.02.2014)</h3>

    <div>
        <ul>
            <li>Handle ??? dim state for EnOcean devices</li>
            <li>Use messenger for external API</li>
            <li>Send intents to Tasker when clicking a button within the app (without relying on
                GCM)
            </li>
            <li>Fix device type of associated CUL_HM devices (channels and so on)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=115&page=1&state=closed"
           target="_blank">2.7.1</a>
        (08.02.2014)</h3>

    <div>
        <ul>
            <li>Make structures dimmable</li>
            <li>Remove manufId for Eltako shutters (recognising more devices as shutters)</li>
            <li>Recognise HM-LC-BL1-FM as shutter device</li>
            <li>Fix bug not showing CUL_HM channel devices</li>
            <li>98_gcmsend: Add a device filter attribute, allowing to filter outgoing notifys by
                device name (a
                whitelist)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=114&page=1&state=closed"
           target="_blank">2.7.0</a>
        (01.02.2014)</h3>

    <div>
        <ul>
            <li>Send Android wide broadcasts if a GCM device state change has occurred. This can be
                used to trigger
                actions within Tasker.
            </li>
            <li>Add a Locale plugin for changing connections. You can use that one to change the
                current connection
                based on WLAN availablity.
            </li>
            <li>Add a connection selector to the send command Locale plugin.</li>
            <li>Add an Intent service for providing device names to external applications (see
                External Interfaces for
                details)
            </li>
            <li>Add pressure graph to TRX_WEATHER devices</li>
            <li>Fix a bug resulting into devices being sorted into wrong functionality groups.</li>
            <li><span style="color:red;font-weight:bold">Note: </span> As the Locale plugins have
                massively changed,
                existing configurations have to be reconfigured, as Locale, Tasker and Llama will
                not find the
                previously existing plugin. Sorry for the inconvenience.
            </li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=113&page=1&state=closed"
           target="_blank">2.6.9</a>
        (18.01.2014)</h3>

    <div>
        <ul>
            <li>Bugfix: Application crash upon fast switching to timetables</li>
            <li>Add support for OWSWITCH devices</li>
            <li>Show an error message if URLs do not start with http</li>
            <li>Bugfix: Resolve error concerning OWDevice parsing</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=112&page=1&state=closed"
           target="_blank">2.6.8</a>
        (11.01.2014)</h3>

    <div>
        <ul>
            <li>Fix bug concerning hue devices</li>
            <li>Repair nested floorplan items</li>
            <li>Make sure that one xmllist read error cannot break the whole loading progress</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=111&page=1&state=closed"
           target="_blank">2.6.7</a>
        (05.01.2014)</h3>

    <div>
        <ul>
            <li>Fix various dim action row errors (hidden up down buttons, wrong minimum value)</li>
            <li>Add support for HM-Sen-Wa-Od fill state sensors</li>
            <li>Add support for OC3 CUL_HM TH_Sensors</li>
            <li>Add support for HM_ES-PMSw1-Pl devices</li>
            <li>Add support for pilight devices</li>
            <li>Show message for outdated sensor data</li>
            <li>EIB/KNX bugfix: ??? states cause andFHEM to crash</li>
            <li>Show FB_CALLMONITOR call durations in seconds, minutes and hours</li>
            <li>Weblink support</li>
            <li>Support for HUE colorpickers</li>
            <li>Updated GCM support (bugfixes, ability to send messages from FHEM) <br/>
                (prerequisite is the new GCM
                module, <a
                        href="http://svn.code.sf.net/p/fhem/code/trunk/fhem/contrib/98_gcmsend.pm">click
                    me</a>)
            </li>
            <li>UI fix for too long device names (resulting in huge table cells)</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=110&page=1&state=closed"
           target="_blank">2.6.6</a>
        (26.12.2013)</h3>

    <div>
        <ul>
            <li>Support for LaCrosse devices</li>
            <li>Consistent image width for remote controls</li>
            <li>Image cache (size 20) for web loaded images (LRU)</li>
            <li>Support for DBLog graphs (beta)</li>
            <li>Better support for FileLog device regexp (now also supporting more complex
                expressions, including OR)
            </li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=109&page=1&state=closed"
           target="_blank">2.6.5</a>
        (20.12.2013)</h3>

    <div>
        <ul>
            <li>Repair error for big weather widget (breaking the application)</li>
            <li>Remove ESA2000 hour_last graph (replaced by day graph)</li>
            <li>Colorise table rows if CUL_HM command was not accepted</li>
            <li>Repair always_hidden hook</li>
            <li>Remove "set_" when parsing temperature lists for CUL_HM</li>
            <li>Add option to configure connection timeouts for FHEMWEB and Telnet (see
                preferences)
            </li>
            <li>Make number of command send retries configurable (see preferences)</li>
            <li>Repair seek bars within preferences (to properly use defaults)</li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=108&state=closed"
           target="_blank">2.6.4</a>
        (14.12.2013)</h3>

    <div>
        <ul>
            <li>Repair device name selection when switching rooms</li>
            <li>Add ReadingsProxy device for color picking</li>
            <li>Add color picker to dummy device</li>
            <li>Change PCA301 device to be sorted as switch device</li>
            <li>Repair CUL_HM timetable heating intervals (now correctly showing the end time of an
                interval)
            </li>
            <li>Do not discard devices when ecountering an update error</li>
            <li>Add ESA2000 day usage series</li>
            <li>Add a preference to change the startup screen (Favorites, All devices, Room List)
            </li>
            <li>Add additional attributes to GPIO4 devices (minimum, maximum and average day and
                month values)
            </li>
            <li>Correctly implement the retry button for failed device switch commands</li>
            <li>Ignore telnet motd message and fhem command prompts</li>
            <li>Show an error message when users enter whitespaces into timer names</li>
            <li>Add RPI_GPIO devices</li>
            <li>Add an ability to send an error message by mail (containing some parts of the
                xmllist and a
                stacktrace)
            </li>
        </ul>
    </div>


    <h3><a href="https://github.com/klassm/andFHEM/issues?labels=&milestone=107&page=1&state=closed"
           target="_blank">2.6.3</a>
        (26.11.2013)</h3>
    <div>
        <ul>
            <li>Repair issues concerncing telnet connections</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?labels=&milestone=106&page=1&state=closed"
           target="_blank">2.6.2</a>
        (24.11.2013)</h3>
    <div>
        <ul>
            <li>Add new updating dialog to the device detail view</li>
            <li>Repair editing of telnet connections</li>
            <li>Repair application crash when using a big weather forecast widget and switching the
                FHEM connection
            </li>
            <li>Add a hook to hide devices from andFHEM</li>
            <li>Repair umlauts when using Telnet</li>
            <li>Massive speedup of Telnet connections</li>
            <li>Support gzip for FHEMWEB connections (speeding up the update progress)</li>
            <li>More information on why server connection fails, incl. new UI (and authentication
                error information for
                Telnet connections)
            </li>
            <li>Command queue for resending failed commands (see <a href="faq.html#resend">FAQ</a>
                for details)
            </li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=105&page=1&state=closed"
           target="_blank">2.6.1</a>
        (18.11.2013)</h3>
    <div>
        <ul>
            <li>Bugfix: Readd missing sliders and fields within device detail views</li>
            <li>Repair the connection type selector background</li>
        </ul>
    </div>

    <h3><a href="https://github.com/klassm/andFHEM/issues?milestone=104&page=1&state=closed"
           target="_blank">2.5.9 /
        2.6.0</a> (17.11.2013)</h3>
    <div>
        <ul>
            <li>Multiple FHEM server profiles
                <ul>
                    <li>Allows to configure an arbitrary amount of FHEM servers</li>
                    <li>Servers can be chosen from the action bar</li>
                    <li>The free versions supports only one FHEM connection</li>
                    <li>Your current connection details will be overtaken. If you
                        are using Telnet and FHEMWEB and are not a Premium user, only FHEMWEB will
                        be overtaken
                    </li>
                    <li>Known issue: Selecting the datasource type when creating a connection got a
                        really strange background ...</li>
                </ul>
            </li>
            <li>Add a hook for showing only a shortname within appwidgets</li>
            <li>Change weather image base url (this will break image loading on old versions soon
                ...)
            </li>
            <li>Allow column widths smaller than 350dp</li>
            <li>Eltako Switching / Shutter</li>
            <li>Make FS20_ZDR a remote control</li>
        </ul>
    </div>

    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=103&amp;page=1&amp;state=closed"
            target="_blank">2.5.8</a> (10.11.2013)</h3>

    <div>
        <ul>
            <li>2.5.7 broke widget selection.</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=102&amp;page=1&amp;state=closed"
            target="_blank">2.5.7</a> (10.11.2013)</h3>

    <div>
        <ul>
            <li>Categorize devices by functionality instead of device type</li>
            <li>Floorplan update (loads floorplan directly from FHEMWEB)</li>
            <li>Big weather widget (incl. forecast scrolling)</li>
            <li>New hook for whoing webcmds within the device overview</li>
            <li>Update indicators within views when loading new information (this is
                more accurate than the updating indicator within the action bar)
            </li>
            <li>Read "currentTitle" and "channel" for remote controls</li>
            <li>Read "mode" attribute for CUL_HM thermostats</li>
            <li>Bugfix: EnOcean dimming command corrected</li>
            <li>Bugfix: Medium weather widget UI)</li>
            <li>Bugfix: Repair HUE device switching</li>
            <li>Bugfix: Additional information switching fails for on-till</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=101&amp;state=closed"
            target="_blank">2.5.6</a> (03.11.2013)</h3>

    <div>
        <ul>
            <li>Removed tabs. The app now uses a much more modern slider layout</li>
            <li>Use a dark action bar (looks much better)</li>
            <li>Animations upon view changes</li>
            <li>Build infrastructure updated to use the new Gradle structure (no more
                Ant, yeah!)
            </li>
            <li>Show favorite view on application start only if favorites are
                configured
            </li>
            <li>Show a manual on how to add favorites if none are found</li>
            <li>Target state appwidget missed functionality to switch commands requiring
                additional information (i.e. desired-temp)
            </li>
            <li>Handle empty billing responses</li>
            <li>Align refresh icon, higher quality icons</li>
            <li>Add support for remotecontrol devices (careful, images are always loaded
                via FHEMWEB. In general, the device is FHEMWEB only!)
            </li>
            <li>Handle EIB date devices</li>
            <li>Support DS18B20 devices</li>
            <li>Prevent application crash upon heating interval deletion</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=100&amp;state=closed"
            target="_blank">2.5.5</a> (26.10.2013)</h3>

    <div>
        <ul>
            <li>Support for PCA301 devices</li>
            <li>Show HCS device demand device names as comma separated lsit</li>
            <li>Suport HM-Sen-Wa-Od devices</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=99&amp;state=closed"
            target="_blank">2.5.4</a> (13.10.2013)</h3>

    <div>
        <ul>
            <li>Repair auto update on application start</li>
            <li>Allow switching of decimal quarters upon on-for-timer and
                off-for-timer
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=98&amp;page=1&amp;state=closed"
            target="_blank">2.5.3</a> (12.09.2013)</h3>

    <div>
        <ul>
            <li>Bugfix: Timer list could break when switching tabs</li>
            <li>Bugfix: Timer device selection repaired after changing the way the back
                button works
            </li>
            <li>FHEM Update: MAX on / off values may appear also in window open and eco
                temperature fields
            </li>
            <li>Support for OpenWeatherMap devices</li>
            <li>AppWidget to switch custom target states (setList based)</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=97&amp;page=1&amp;state=closed">2.5.2</a>
        (07.09.2013)</h3>

    <div>
        <ul>
            <li>Bugfix: Image loading breaks in some special circumstances</li>
            <li>Bugfix: Available target states switching breaks on old Android
                versions
            </li>
            <li>Bugfix: Advertisements repaired</li>
            <li>Bugfix: Show FHT actuator graph even if temperature attribute is unset
            </li>
            <li>Bugfix: Allow FB_Callmonitor entries without an associated event</li>
            <li>FHEM Update: Repair MAX devices to allow on and off in desired-temp
                values
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=96&amp;state=closed"
            target="_blank">2.5.1</a> (01.09.2013)</h3>

    <div>
        <ul>
            <li>Reduced memory consumption</li>
            <li>Various bugfixes resolving UI glitches and application crashes</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=94&amp;state=closed"
            target="_blank">2.4.9</a> / <a
            href="https://github.com/klassm/andFHEM/issues?milestone=95&amp;page=1&amp;state=closed">2.5.0</a>
        (25.08.2013)</h3>

    <div>
        <ul>
            <li>Respect eventMap for setList texts</li>
            <li>Add container device for FS20_ZDR (<a
                    href="http://svn.code.sf.net/p/fhem/code/trunk/fhem/contrib/98_FS20_ZDR.pm"
                    target="_blank">Module</a>, <a
                    href="http://forum.fhem.de/index.php?t=msg&amp;th=14437&amp;start=0&amp;rid=536"
                    target="_blank">FHEM forum thread</a>)
            </li>
            <li>Update FS20_ZDR state only for on and off states</li>
            <li>Repair on/off button layout</li>
        </ul>
    </div>
    <h3><a
            href="http://svn.code.sf.net/p/fhem/code/trunk/fhem/contrib/98_gcmsend.pm"
            target="_blank">98_gcmsend.pm</a> (25.08.2013)</h3>

    <div>
        <ul>
            <li>add state filter option</li>
            <li>print less log messages</li>
            <li>module put to contrib folder of FHEM</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=93&amp;page=1&amp;state=closed">2.4.8</a>
        (15.08.2013</h3>

    <div>
        <ul>
            <li>Resolve crash when receiving floorplan data</li>
            <li>Resolve crash when receiving commands sent manually via the send command
                view
            </li>
            <li>Fix custom graphs</li>
            <li>Resolve layout issue for webcmds</li>
        </ul>
    </div>
    <h3><a
            href="http://svn.code.sf.net/p/fhem/code/trunk/fhem/contrib/98_gcmsend.pm"
            target="_blank">98_gcmsend.pm</a> (11.08.2013)</h3>

    <div>
        <ul>
            <li>Send only device updates if the attribute value has changed</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=92&amp;page=1&amp;state=closed">2.4.7</a>
        (10.08.2013)</h3>

    <div>
        <ul>
            <li>Leftover localization for FB_CALLMONITOR</li>
            <li>WebCmd support</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=91&amp;page=1&amp;state=closed">2.4.6</a>
        (09.08.2013)</h3>

    <div>
        <ul>
            <li>Support for <a href="http://fhem.de/commandref.html#FB_CALLMONITOR">FB_CALLMONITOR</a>
                (great in combination with GCM!)
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=90&amp;page=1&amp;state=closed">2.4.5</a>
        (08.08.2013)</h3>

    <div>
        <ul>
            <li>Test: Show progress icon instead of executing dialog (feedback
                appreciated)
            </li>
            <li>Add basic support for SWAP devices</li>
            <li>Set device dim max value instead of on</li>
            <li>Fix marking of selected devices in detail view</li>
            <li>Read superclass attributes for GCM notifications when receiving multiple
                attributes
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=89&amp;page=1&amp;state=closed">2.4.4</a>
        (27.07.2013)</h3>

    <div>
        <ul>
            <li>Fix error while switching to top level tab</li>
            <li>Option to enable widget updates upon GCM notification (consumes loads of
                battery, has to be enabled in preferences)
            </li>
            <li>Repair GCM registration message if the project id is invalid
                (registrationId will be empty)
            </li>
            <li>Basic support for ZWave devices</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=88&amp;page=1&amp;state=closed">2.4.3</a>
        (26.07.2013)</h3>

    <div>
        <ul>
            <li>Repair bug with registering GCM devices</li>
            <li>Notifications for GCM updates</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=87&amp;page=1&amp;state=closed">2.4.2</a>
        (21.7.2013)</h3>

    <div>
        <ul>
            <li>Updates via Google Cloud MessagingGCM update (see <a
                    href="http://andfhem.klass.li/installation">https://sites.google.com/site/andfhem/installation</a>)
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=86&amp;page=1&amp;state=closed">2.4.1</a>
        (29.06.2013)</h3>

    <div>
        <ul>
            <li>Update state field upon dimming</li>
            <li>Add FHT8V actuator graph</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=85&amp;page=1&amp;state=closed">2.4.0</a>
        (23.06.2013)</h3>

    <div>
        <ul>
            <li>Fix CUL_HM tempList issue</li>
            <li>Fix discrete values in graphs</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=84&amp;page=1&amp;state=closed">2.3.9</a>
        (16.06.2013)</h3>

    <div>
        <ul>
            <li><b>Urgent update:</b> Battery eating widget issue resolved.<br/>If you
                still experience this problem, please reinstall the application.
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=83&amp;page=1&amp;state=closed">2.3.8</a>
        (15.06.2013)</h3>

    <div>
        <ul>
            <li>Configurable update interval for WLAN and mobile</li>
            <li>CUL_HM THSensor graph pattern adaption to spec in temp4hum6.gplot</li>
            <li>DummyDevice slider setState attribute</li>
            <li>HueDevice state on and off and corresponding wrong dim states</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=82&amp;page=1&amp;state=closed">2.3.7</a>
        (08.06.2013)</h3>

    <div>
        <ul>
            <li>Add FRM_IN, YAMAHA_AVR, ESA2000, HUE and FRM_OUT devices</li>
            <li>Correct EIB dimmer command</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=81&amp;state=closed">2.3.6</a>
        (08.06.2013)</h3>

    <div>
        <ul>
            <li>Make graph series colors stay the same (i.e. same color for temperature
                series)
            </li>
            <li>CUL_TX humidity graph axis description repaired</li>
            <li>GPIO4 device added</li>
            <li>CUL_HM THSensor temperature graph (without humidity)</li>
            <li>Show error message if no graph data can be shown</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=80&amp;page=1&amp;state=closed">2.3.5</a>
        (04.06.2013)</h3>

    <div>
        <ul>
            <li>Graphs refactored (Hopefully I did not break anything. If you encounter
                some new issues here, please send me an email. This especially concerns
                sum graphs). In effect, scaling of axis should work now. Scale buttons
                are also back.
            </li>
            <li>EIB device list loading bug</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=79&amp;page=1&amp;state=closed">2.3.4</a>
        (02.06.2013)</h3>

    <div>
        <ul>
            <li>Show "invisible" graph labels</li>
            <li>Deterministic graph series order</li>
            <li>Timer creation fix part 2</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=78&amp;page=1&amp;state=closed">2.3.3</a>
        (01.06.2013)</h3>

    <div>
        <ul>
            <li>EIB dimmer support, temperature graph</li>
            <li>Repair timespan selection for graphs</li>
            <li>Repair timer device selection</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=77&amp;page=1&amp;state=closed">2.3.2</a>
        (25.05.2013)</h3>

    <div>
        <ul>
            <li>Repair small widgets</li>
            <li>Repair NullPointer on tab switching</li>
            <li>Add EIB dpt10 devices</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=76&amp;page=1&amp;state=closed"
            target="_blank">2.3.1</a> (19.05.2013)</h3>

    <div>
        <ul>
            <li>Fix appwidget size</li>
            <li>Fix application error on screen rotation</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=75&amp;page=1&amp;state=closed">2.3.0</a>
        (04.05.2013)</h3>

    <div>
        <ul>
            <li>Support GenShellSwitch devices</li>
            <li>Fix bug due to out of memory errors on older / weaker devices</li>
            <li>All medium widgets can be used on lock screens</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=74&amp;page=1&amp;state=closed">2.2.9</a>
        (28.04.2013)</h3>

    <div>
        <ul>
            <li>Enable floorplan for TRX_LIGHT devices</li>
            <li>Add CUL_EM total usage attribute</li>
            <li>Auto-start update if preferences have changed (change of view is still
                required after coming back from the preferences view)
            </li>
            <li>Remaining Sonos support (pause, play, stop, forward, rewind buttons)
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=73&amp;page=1&amp;state=closed">2.2.8</a>
        (21.04.2013)</h3>

    <div>
        <ul>
            <li>basic SonosPlayer support</li>
            <li>correct FHT offtime in timetables</li>
            <li>Add EMWZ to dummy data</li>
            <li>Make FBDectDevice toggleable</li>
            <li>Bigger seekbar thumb selectors</li>
            <li>Align on / off buttons to the right side</li>
            <li>Allow tab reselection</li>
            <li>Fewer memory consumption for older devices (pre 4.0)<br/>=&gt; Changing
                views during update is no longer possible for those devices
            </li>
            <li>Jump to correct page when clicking on widgets</li>
            <li>Dim widget view</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues/377">2.2.7</a> (15.04.2013)
    </h3>

    <div>
        <ul>
            <li>Fix null pointer upon back press</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=71&amp;page=1&amp;state=closed">2.2.6</a>
        (13.04.2013)</h3>

    <div>
        <ul>
            <li>Add FBDect device</li>
            <li>Repair Timer creation and editing
                <ul>
                    <li>device selection no longer worked</li>
                    <li>on-for-timer appendix value was not inserted upon editing</li>
                </ul>
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=70&amp;page=1&amp;state=closed">2.2.5</a>
        (06.04.2013)</h3>

    <div>
        <ul>
            <li>FHEM Uri integration (use fhem://someCommand urls to start an FHEM
                command using andFHEM)
            </li>
            <li>Disable big appwidgets (did not contain any selectable widgets)</li>
            <li>Repair Yahoo weather images</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=69&amp;page=1&amp;state=closed">2.2.4</a>
        (01.04.2013)</h3>

    <div>
        <ul>
            <li>PRESENCE device support</li>
            <li>MAX HeatingThermostatPlus support</li>
            <li>Dummy device set time support</li>
            <li>EMZW device support</li>
            <li>Swipe navigation between tabs</li>
            <li>Improved navigation code (more stable, faster)</li>
            <li>Navigate while pulling a new device list</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=68&amp;page=1&amp;state=closed">2.2.3</a>
        (24.03.2013)</h3>

    <div>
        <ul>
            <li>Add ability to add custom graphs (see <a
                    href="http://andfhem.klass.li/hooks">Hooks</a>)
            </li>
            <li>Always add a 00:00 switch time for MAX devices</li>
            <li>Add pair and alert buttons for TRX_SECURITY</li>
            <li>Telnet: Suppress empty responses when sending manual commands, fix
                device deletion
            </li>
            <li>Fix / cleanup Telnet graph loading</li>
            <li>Code restructurings part 1</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=67&amp;page=1&amp;state=closed">2.2.2</a>
        (19.03.2013)</h3>

    <div>
        <ul>
            <li>Add TRX_Security devices</li>
            <li>FHEM security message caused telnet connection to break</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=66&amp;page=1&amp;state=closed">2.2.1</a>
        (17.03.2013)</h3>

    <div>
        <ul>
            <li>Add UNIRoll devices</li>
            <li>Switch to commons.net for telnet connection, repair timeout</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=65&amp;page=1&amp;state=closed">2.2.0</a>
        (11.03.2013)</h3>

    <div>
        <ul>
            <li>Max Journal device bug (\B0 instead of °)</li>
            <li>WOL device shutdown button</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=64&amp;state=closed">2.1.9</a>
        (10.03.2013)</h3>

    <div>
        <ul>
            <li><span
                    style="font-size:1em;line-height:1.5">Support OwSwitch devices</span>
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=63&amp;page=1&amp;state=closed">2.1.8</a>
        (28.02.2013)</h3>

    <div>
        <ul>
            <li>Fix MAX devices (journal loading)</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=62&amp;state=closed"
            target="_blank">2.1.7</a> (24.02.2013)</h3>

    <div>
        <ul>
            <li>CUL_HM, MAX heating schedules (feedback appreciated, this was a huge
                change)
            </li>
            <li>Tasker plugins with state regexp matching</li>
            <li>Fix CUL_HM thsensor, CUL_WS, KS300 and weather graphs</li>
            <li>Add images when ads are not able to load</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=61&amp;page=1&amp;state=closed">2.1.6</a>
        (18.02.2013)</h3>

    <div>
        <ul>
            <li>Bugfix: EIB time model</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=60&amp;page=1&amp;state=closed">2.1.5</a>
        (17.02.2013)</h3>

    <div>
        <ul>
            <li>Error message for empty graphs (could break andFHEM)</li>
            <li>Bugfix: Show CUL_HM desired-temp in overview</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=59&amp;page=1&amp;state=closed">2.1.4</a>
        (16.02.2013)</h3>

    <div>
        <ul>
            <li>Open andFHEM when clicking on the new heating widget</li>
            <li>Show MAX temperature graph also if no actuator is currently set</li>
            <li>Do not serialize AssociatedDeviceCallback, breaking andFHEM with HCS
                devices
            </li>
            <li>UI for Llama / Locale / Tasker switching / getting device states
                (feedback appreciated)
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=58&amp;page=1&amp;state=closed">2.1.3</a>
        (11.02.2013)</h3>

    <div>
        <ul>
            <li>FHT heating widget incl. window open image</li>
            <li>Show keymatic CUL_HM devices</li>
            <li>Graphing update incl. multiple y-axis</li>
            <li>CUL_HM heating graphs</li>
            <li>Make CUL_HM control mode settable if not having been set yet</li>
            <li>EIB device support for speed, light, temp and rainsensors</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?labels=&amp;milestone=57&amp;page=1&amp;state=closed">2.1.2</a>
        (03.02.2013)</h3>

    <div>
        <ul>
            <li>repair CUL_WS and CUL_HM graphs (changed log structure)</li>
            <li>show CUL_HM desired-temp in overview</li>
            <li>CUL_HM controlMode switching (without party mode)</li>
            <li>Add EIB setList action row</li>
            <li>Repair AT weekday dependent creation</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=56&amp;page=1&amp;state=closed">2.1.1</a>
        (27.01.2013)</h3>

    <div>
        <ul>
            <li>Llama integration documented. This is a very raw API to send command to
                FHEM via andFHEM. Actually, it should also work with Tasker and Locale.
                Feedback appreciated!
            </li>
            <li>Use new log structure of CUL_HM to display temperature and humidity
                graphs
            </li>
            <li>HCS bug fixes</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=55&amp;page=1&amp;state=closed">2.1.0</a>
        (20.01.2013)</h3>

    <div>
        <ul>
            <li>Cleanup dummy data rooms</li>
            <li>Use MAX heating "mode" attribute</li>
            <li>Relax EventMap parsing</li>
            <li>Support CUL_HM motion detector</li>
            <li>Support HCS devices</li>
            <li>Clicking on widgets did not always open device detail view</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=54&amp;page=1&amp;state=closed">2.0.9</a>
        (14.01.2013)</h3>

    <div>
        <ul>
            <li>Fix for PID "desired" state parsing error</li>
            <li>Better device list parsing (don't stop after one error occurred but
                continue and display errors at the end)
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=53&amp;page=1&amp;state=closed">2.0.8</a>
        (13.01.2013)</h3>

    <div>
        <ul>
            <li>Repair measure time in MAX devices</li>
            <li>Repair heating mode command</li>
            CUL_HM: use measured-temp attribute to read the current temperature
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=51&amp;page=1&amp;state=closed">2.0.6</a>
        / 2.0.7 (12.01.2013)</h3>

    <div>
        <ul>
            <li>MAX: Support wall mounted thermostat devices</li>
            <li>Repair Owtherm device states (broken by fhem update)</li>
            <li>Make rawToReadable non-required</li>
            <li>Show CUL_HM channels, even if not having an associated subtype attribute
                (broken by fhem update)
            </li>
            <li>Allow non lowercase setList items</li>
            <li>Aequire pct percentage attribute in at device state selection</li>
            <li>Add support for structure devices</li>
            <li>Reeanble weather icons<br/>(Hint: The devices are placed on
                andfhem.klass.li and not loaded from your local fhem instance. This
                makes sure that telnet users also can see the images.)
            </li>
            <li><b>2.0.7: Urgent fix for weather devices (caused application crash)</b>
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=50&amp;state=closed">2.0.5</a>
        (06.01.2013)</h3>

    <div>
        <ul>
            <li>No more autocomplete in FHEMWEB URLs</li>
            <li>Display a notification message when using dummy data</li>
            <li>Repair toggle widgets for onOffDevice hooked devices</li>
            <li>Hooks for declaring on and off field names</li>
            <li>Repair desired-temp for CUL_HM devices</li>
            <li>Support setList for dummy devices</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=49&amp;page=1&amp;state=closed">2.0.4</a>
        (26.12.2012)</h3>

    <div>
        <ul>
            <li>Basic EIB device support</li>
            <li>Mark off devices with a red bar</li>
            <li>Replace progress fragment with a more reliable progress dialog</li>
            <li>Update background image in floorplan view on screen rotation change</li>
            <li>Always display device name list in only one column (except appwidget
                selection)
            </li>
            <li>Repair CUL_HM desired-temp, which was always displayed</li>
            <li>Ability to hide and show connection password</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=48&amp;page=1&amp;state=closed">2.0.3</a>
        (16.12.2012)</h3>

    <div>
        <ul>
            <li>Resolve timer edit / creation error for old Android versions</li>
            <li>Resolve holiday_short algorithm error for switching to the same hour as
                currently is
            </li>
            <li>EnOcean device eventMap support</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=47&amp;page=1&amp;state=closed">2.0.2</a>
        (09.12.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: CUL_HM blindActuator switching did not respect eventMap</li>
            <li>Bugfix: FHT holiday_short holiday1 algorithm corrected</li>
            <li>Bugfix: Respect braces in FileLog patterns</li>
            <li>CUL_HM: desired-temp switching for thermostat devices, graphs for
                thermostat devices
            </li>
            <li>MAX: switching of desired-temp, comfort-temp, eco-temp, temperature
                widget support
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=46&amp;state=closed">2.0.1</a>
        (02.12.2012)</h3>

    <div>
        <ul>
            <li>holiday_short mode corrected</li>
            <li>spinner selection for FHT modes repaired</li>
            <li>MAX device support (basic)</li>
            <li>Toggle widget invert hook verified and onOffDevice widgets repaired</li>
            <li>EventReceiver for FHEM push messages (thanks @Zoldan!)<br/>Be careful
                with that feature. It is connected all the time to FHEM and reports any
                new events. Consequently, it consumes _some_ battery.
            </li>
            <li>Switch buttons for dummy devices</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=45&amp;page=1&amp;state=closed">2.0.0</a>
        (25.11.2012)</h3>

    <div>
        <ul>
            <li>FHT holiday / holiday_short support</li>
            <li>Respect onDevice / offDevice hooks in toggle widgets</li>
            <li>Timer weekday dependent switching</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=44&amp;page=1&amp;state=closed">1.9.9</a>
        (18.11.2012)</h3>

    <div>
        <ul>
            <li>Owtherm device support</li>
            <li>Always show FHT temperature sliders</li>
            <li>Invert state hook (see <a href="http://andfhem.klass.li/hooks">Hooks</a>
                for details)
            </li>
            <li>Bugfix: CUL_HM thermostat support</li>
            <li>Bugfix: EnOcean device application crash</li>
            <li>Bugfix: FHT window-open and night-temp sliders repaired</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=43&amp;state=closed">1.9.8</a>
        (13.11.2012)</h3>

    <div>
        <ul>
            <li>Hotfix for never ending widget updates</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=42&amp;page=1&amp;state=closed">1.9.7</a>
        (10.11.2012)</h3>

    <div>
        <ul>
            <li>add CUL_HM thermostat subtype</li>
            <li>add EN_OCEAN switch and sensor support</li>
            <li>fix timer parsing for dots in extra information</li>
            <li>update widgets when fetching remote device list</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=41&amp;state=closed">1.9.6</a>
        (03.11.2012)</h3>

    <div>
        <ul>
            <li>Pid device xml parsing issue resolved</li>
            <li>Show FHT devices on floorplans</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=40&amp;page=1&amp;state=closed">1.9.5</a>
        (27.10.2012)</h3>

    <div>
        <ul>
            <li>Switch PIDDevice desired temperature</li>
            <li>Bugfix: medium toggle device switch text</li>
            <li>Bugfix: No devices available message for widget device selection</li>
            <li>toggle button hook (see hooks page for details)</li>
            <li>AtDevice / timer on and off buttons</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=39&amp;page=1&amp;state=closed">1.9.4</a>
        (20.10.2012)</h3>

    <div>
        <ul>
            <li>repair nullpointer in SendCommandFragment</li>
            <li>enable onOffDevice hook for dim devices</li>
            <li>add an onDevice and offDevice hook (see Hooks for more info)</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=38&amp;state=closed">1.9.3</a>
        (19.10.2012)</h3>

    <div>
        <ul>
            <li>Toggle widget for HM-LC-BL1-FM devices</li>
            <li>FHT timer target states were displayed wrong</li>
            <li>Better delete confirmation message</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=37&amp;page=1&amp;state=closed">1.9.2</a>
        (13.10.2012)</h3>

    <div>
        <ul>
            <li>Event map usage for medium toggle widget</li>
            <li>Option to get some right padding within the device list</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=36&amp;page=1&amp;state=closed">1.9.1</a>
        (04.10.2012)</h3>

    <div>
        <ul>
            <li>TRX_WEATHER rain and wind attributes</li>
            <li>merge dewpoint and temperature graphs</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=35&amp;state=closed">1.9.0</a>
        (03.10.2012)</h3>

    <div>
        <ul>
            <li>Dewpoint, humidity and graphs for TRX_WEATHER devices</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=34&amp;page=1&amp;state=closed">1.8.9</a>
        (01.10.2012)</h3>

    <div>
        <ul>
            <li>Repair FHT actuator graph</li>
            <li>Disable Weather device images (I will introduce them whenever updatefhem
                delivers the weather images to your local FHEM instance)
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=33&amp;page=1&amp;state=closed">1.8.8</a>
        (10.09.2012)</h3>

    <div>
        <ul>
            <li>New HOL device attributes</li>
            <li>Bugfix: Clear click path on tab click</li>
            <li>Bugfix: Update on application start did update loads too often</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=32&amp;page=1&amp;state=closed">1.8.7</a>
        (08.09.2012)</h3>

    <div>
        <ul>
            <li>TRX_LIGHT dimming part 2 (only issue "set device level xx")</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=31&amp;page=1&amp;state=closed">1.8.6</a>
        (01.09.2012)</h3>

    <div>
        <ul>
            <li>Bug: FHT temperature was not shown</li>
            <li>Bug: FHT change temperature to "" produces an application crash</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=30&amp;page=1&amp;state=closed">1.8.5</a>
        (19.08.2012)</h3>

    <div>
        <ul>
            <li>TRX_LIGHT dimming support</li>
            <li>FHT temperature sliders fixed (are limited to 30.5 degrees again)</li>
            <li>Sliders in detail view use the full width of the screen</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=29&amp;page=1&amp;state=closed">1.8.4</a>
        (15.08.2012)</h3>

    <div>
        <ul>
            <li>Various device list parsing bugfixes</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=28&amp;state=closed">1.8.3</a>
        (12.08.2012)</h3>

    <div>
        <ul>
            <li>Various smaller bugfixes (HomeMatic, Billing Service, ...)</li>
            <li>Changed the Floorplan URL to the new FHEM convention. If your Floorplan
                does not work any more, execute <i>updatefhem</i>.
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=27&amp;page=1&amp;state=closed">1.8.2</a>
        (05.08.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: display aliases</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=26&amp;page=1&amp;state=closed">1.8.1</a>
        (04.08.2012)</h3>

    <div>
        <ul>
            <li>Ignore "offset" as FHT actor state</li>
            <li>Bugfix: Google Weather forecast was shown one day in advance</li>
            <li>Bugfix: At device timer shows two times weekend as repetition</li>
            <li>Sort CUL_HM devices by subtype and name</li>
            <li>KFM100 fill state percentage</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=25&amp;page=1&amp;state=closed">1.8.0</a>
        (29.07.2012)</h3>

    <div>
        <ul>
            <li>Repair dummy data</li>
            <li>KFM100 fill state graphic</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=24&amp;state=closed">1.7.9</a>
        (28.07.2012)</h3>

    <div>
        <ul>
            <li>Homematic KFM100 devices</li>
            <li>Fix umlauts problem within Telnet connection</li>
            <li>Fix orientation change problem</li>
            <li>Text input to adjust FHT temperatures can be enabled within the
                preferences menu
            </li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=23&amp;state=closed">1.7.8</a>
        (25.07.2012)</h3>

    <div>
        <ul>
            <li>Device type reordering with drag &amp; drop</li>
            <li>CUL_HM temperature graph bugfix</li>
            <li>Enable updating on application start</li>
            <li>Recreate product database</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=22&amp;page=1&amp;state=closed">1.7.7</a>
        (23.07.2012)</h3>

    <div>
        <ul>
            <li>dummy on/off buttons</li>
            <li>FS20 state graph</li>
            <li>KS300 graphs showing only the rain delta</li>
            <li>Support Homematic THSensor subtype</li>
            <li>Set default device grid width to 355 dp</li>
            <li>Changed button style to match the current application style</li>
            <li>Hide hidden devices also in the All Devices view</li>
            <li>Filter and reorder devices (see preference page)</li>
            <li>Bugfix: delete device aliases</li>
            <li>Bugfix: retain fragments while changing the screen orientation</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=21&amp;page=1&amp;state=closed">1.7.6</a>
        (19.07.2012)</h3>

    <div>
        <ul>
            <li>Repair in-app-billing (if your purchase is not displayed, press refresh
                within the premium view)
            </li>
            <li>Maximum device column width dependent of device width and height</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=20&amp;page=1&amp;state=closed">1.7.5</a>
        (18.07.2012)</h3>

    <div>
        <ul>
            <li>Resolved seekbar width error</li>
            <li>Column width is now adjustable to everyone's needs</li>
            <li>Twilight and TRX_LIGHT devices are supported</li>
            <li>Device list is not updated all the time, resulting in performance
                gains
            </li>
            <li>Adjustable widget update time</li>
            <li>Buy premium button repaired</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=19&amp;page=1&amp;state=closed">1.7.4</a>
        (16.07.2012)</h3>

    <div>
        <ul>
            <li>Tablet / multi-column layout</li>
            <li>forecast widget with preview images</li>
            <li>various bugfixes</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=18&amp;page=1&amp;state=closed">1.7.3</a>
        (07.07.2012)</h3>

    <div>
        <ul>
            <li>Various bugfixes</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=17&amp;page=1&amp;state=closed">1.7.2</a>
        (05.07.2012)</h3>

    <div>
        <ul>
            <li>Create (some) timers from within andFHEM</li>
            <li>Various bug fixes</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=16&amp;page=1&amp;state=closed">1.7.1</a>
        (29.06.2012)</h3>

    <div>
        <ul>
            <li>Telnet password support (if this breaks your application, make sure you
                are running the most recent version of FHEM!)
            </li>
            <li>More Amazon billing</li>
            <li>Various bug fixes</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=15&amp;state=closed">1.7.0</a>
        (26.06.2012)</h3>

    <div>
        <ul>
            <li>upcoming support for Amazon Market</li>
            <li>loads of bug fixes (see Github milestone for more detail)</li>
        </ul>
    </div>
    <h3><a
            href="https://github.com/klassm/andFHEM/issues?milestone=14&amp;page=1&amp;state=closed">1.6.9</a>
        (19.06.2012)</h3>

    <div>
        <ul>
            <li>CUL_TX temperature widget, graphs</li>
            <li>on / off buttons can be displayed instead of toggle buttons (see <a
                    href="http://andfhem.klass.li/hooks">Hooks</a>)
            </li>
            <li>various bug fixes (see Github milestone for more detail)</li>
        </ul>
    </div>
    <h3>1.6.8 (17.06.2012)</h3>

    <div>
        <ul>
            <li>Loads of home screen appwidgets<br/>(breaks compatibility with the old
                toggle widgets, just remove and re-add it)
            </li>
            <li>Support for CUL_TX devices</li>
        </ul>
    </div>
    <h3>1.6.7 (08.06.2012)</h3>

    <div>
        <ul>
            <li>Move devices on the floorplan (drag &amp; drop) (long click on device)
            </li>
            <li>Jump from the floorplan to device detail pages (long click on device)
            </li>
            <li>Disable floorplan for pre Android 3 devices<br/>(pre Android 3 versions
                do not support for scaling views, there seems to be no workaround)
            </li>
            <li>Support dummy devices inkl. switching</li>
        </ul>
    </div>
    <h3>1.6.6 (07.06.2012)</h3>

    <div>
        <ul>
            <li>View floorplans / switch devices</li>
        </ul>
    </div>
    <h3>1.6.5 (20.05.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: Send command breaks on pre Android 3</li>
            <li>Bugfix: FHT temperature command seekbars have disappeared</li>
            <li>Hex Conversion GUI</li>
        </ul>
    </div>
    <h3>1.6.4 (17.05.2012)</h3>

    <div>
        <ul>
            <li>Detail views for every supported device<br/>(including device
                definitions for the devices)
            </li>
            <li>Basic support for Intertechno devices (toggle)<br/>(if someone wants to
                see dimmers supported, please send me an excerpt of your device list)
            </li>
            <li>Execute any user-defined command<br/>(inkl. command history)</li>
        </ul>
    </div>
    <h3>1.6.3 (14.05.2012)</h3>

    <div>
        <ul>
            <li>handle exceptions in BillingService</li>
        </ul>
    </div>
    <h3>1.6.2 (13.05.2012)</h3>

    <div>
        <ul>
            <li>introduce ads</li>
            <li>introduce in-app payment to buy a premium version without ads</li>
        </ul>
    </div>
    <h3>1.6.1 (05.05.2012)</h3>

    <div>
        <ul>
            <li>bugfix: use event map for FS20 device switching</li>
            <li>fix attribute description for KS300 devices</li>
            <li>buttons for FS20 dim up and down in FS20 detail view</li>
        </ul>
    </div>
    <h3>1.6.0 (04.05.2012)</h3>

    <div>
        <ul>
            <li>repair cache for faster application start up</li>
            <li>fix an xmllist parsing error for htmlattr (invalid xml from FHEM)</li>
            <li>handle invalid eventList attribute values</li>
        </ul>
    </div>
    <h3>1.5.9 (01.05.2012)</h3>

    <div>
        <ul>
            <li>Support for WEATHER devices</li>
        </ul>
    </div>
    <h3>1.5.8 (18.04.2012)</h3>

    <div>
        <ul>
            <li>Fix CUL_WS graphs</li>
        </ul>
    </div>
    <h3>1.5.7 (14.04.2012)</h3>

    <div>
        <ul>
            <li>resolve bug concerning not <a
                    href="https://github.com/klassm/andFHEM/issues/20">responding
                lists</a></li>
            <li>accept "off" as value for desired-temp in FHT devices</li>
        </ul>
    </div>
    <h3>1.5.6 (10.04.2012)</h3>

    <div>
        <ul>
            <li>support for TRX and TRX_WEATHER devices</li>
            <li>event map support for maps like <i><span>/</span>off-for-timer
                12:Ab80/off:Ab/on:Auf<span>/</span></i></li>
        </ul>
    </div>
    <h3>1.5.4 / 1.5.5 (22.03.2012)</h3>

    <div>
        <ul>
            <li>bugfix for Gingerbread devices</li>
        </ul>
    </div>
    <h3>1.5.3 (22.03.2012)</h3>

    <div>
        <ul>
            <li>support for PID and FHT8V (basic, only device list)</li>
            <li>basic event map support (feel free to find errors!)</li>
            <li>enhances navigation (fragment state is safed)</li>
        </ul>
    </div>
    <h3>1.5.2 (01.03.2012)</h3>

    <div>
        <ul>
            <li>show an error message if the XHR attribute for FHEM is not yet supported
                by FHEMWEB
            </li>
        </ul>
    </div>
    <h3>1.5.1 (18.02.2012)</h3>

    <div>
        <ul>
            <li>some minor style improvements</li>
        </ul>
    </div>
    <h3>1.5.0 (12.02.2012)</h3>

    <div>
        <ul>
            <li>use XHR command for FHEMWEB</li>
            <li>bigger seek views for better selecting temperatures for FHT devices</li>
            <li>some bug fixes</li>
        </ul>
    </div>
    <h3>1.4.9 (05.02.2012)</h3>

    <div>
        <ul>
            <li>adaptable division factor for CUL_EM sum graph</li>
            <li>bugfix for Android 2.3 and prior for selecting devices in the list</li>
            <li>fix for unknown FHT modes</li>
        </ul>
    </div>
    <h3>1.4.8 (04.02.2012)</h3>

    <div>
        <ul>
            <li>CUL_EM sum graph</li>
        </ul>
    </div>
    <h3>1.4.7 (04.02.2012)</h3>

    <div>
        <ul>
            <li>fix back button issue</li>
        </ul>
    </div>
    <h3>1.4.6 (03.02.2012)</h3>

    <div>
        <ul>
            <li>more bug fixes</li>
            <li>custom theme for the App to also look good on ICS</li>
        </ul>
    </div>
    <h3>1.4.5 (03.02.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: works on ICS now</li>
        </ul>
    </div>
    <h3>1.4.4 (02.02.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: navigation flow, save instance on screen rotation</li>
        </ul>
    </div>
    <h3>1.4.3 (02.02.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: app broke when calling preferences from device detail view</li>
            <li>Bugfix: showing a device detail view and turning the device resulted in
                showing the favorites view
            </li>
            <li>FHT confirmation messages improved</li>
        </ul>
    </div>
    <h3>1.4.2 (02.02.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: When using Telnet connection and setting graph time span to less
                than 24 hours, graphs are not showing
            </li>
            <li>Bugfix: executing window did not disappear in some cases</li>
            <li>Bugfix: update progress icon did not disappear in some cases</li>
            <li>layout adaption</li>
        </ul>
    </div>
    <h3>1.4.1 (01.02.2012)</h3>

    <div>
        <ul>
            <li>FHT timetable view now also got the top bar</li>
        </ul>
    </div>
    <h3>1.4.0 (01.02.2012)</h3>

    <div>
        <ul>
            <li>Better looking tabs in landscape mode</li>
            <li>Bugfix: app breaks when fast switching views during update</li>
        </ul>
    </div>
    <h3>1.3.9 (01.02.2012)</h3>

    <div>
        <ul>
            <li>auto update functionality</li>
            <li>Bugfix: charting date selection did not work</li>
        </ul>
    </div>
    <h3>1.3.8 (01.02.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: application breaks when switching to landscape mode</li>
        </ul>
    </div>
    <h3>1.3.7 (01.02.2012)</h3>

    <div>
        <ul>
            <li>move to fragments API, ActionBarSherlock =&gt; new action bar with new
                look<br/>=&gt; let there be bugs !
            </li>
            <li>Inquiry whether day-temp, window-opentemp or night-temp really should be
                changed
            </li>
            <li>selectable graph start and ending hours</li>
            <li>default time span for graphs adjustable in preferences</li>
            <li>temperature ending value is changed from (Celsius) to (°C)</li>
            <li>FHT refreshvalues button</li>
            <li style="list-style-position:outside;list-style-type:square">Bugfix: fix
                charting activity bug for month ending
            </li>
            <li>Bugfix: getTextContent() is not available on all devices</li>
        </ul>
    </div>
    <h3>1.3.6 (28.01.2012)</h3>

    <div>
        <ul>
            <li>fix bug for multiple toggle widget instances</li>
            <li>reflect changed CUL_FHTTK module</li>
        </ul>
    </div>
    <h3>1.3.5 (27.01.2012)</h3>

    <div>
        <ul>
            <li>more logging for finding errors</li>
        </ul>
    </div>
    <h3>1.3.4 (26.01.2012)</h3>

    <div>
        <ul>
            <li>adapted overview layout for CUL_FHTTK</li>
            <li>fixed one more special case for device list validation</li>
            <li>dynamic chart y-axis offset (10%)</li>
        </ul>
    </div>
    <h3>1.3.3 (25.01.2012)</h3>

    <div>
        <ul>
            <li>repair CUL_EM charts</li>
        </ul>
    </div>
    <h3>1.3.2 (24.01.2012)</h3>

    <div>
        <ul>
            <li>basic SSL support (accepts all certificates, testers welcome ...)</li>
            <li>CUL_FHTTK previous state support</li>
            <li>CUL_EM charting (tester welcome ...)</li>
        </ul>
    </div>
    <h3>1.3.1 (24.01.2012)</h3>

    <div>
        <ul>
            <li>error message on authentication failure (FHEMWEB)</li>
            <li>transform FS20 hex device definitions</li>
            <li>repair FS20 context menu</li>
            <li>on and off for timer for FS20 devices</li>
        </ul>
    </div>
    <h3>1.3.0 (23.01.2012)</h3>

    <div>
        <ul>
            <li>small bug fixes</li>
            <li>new icon</li>
        </ul>
    </div>
    <h3>1.2.9 (22.01.2012)</h3>

    <div>
        <ul>
            <li>support WOL module</li>
            <li>bugfix for device deletion</li>
            <li>bugfix for unset FHT modes</li>
        </ul>
    </div>
    <h3>1.2.8 (19.01.2012)</h3>

    <div>
        <ul>
            <li>add linear regression series for temperature charts</li>
            <li>resolve charting bug not showing the last entry</li>
            <li>resolve not disappearing error message</li>
            <li>support multiple rooms separated by comma (i.e. kitchen,bathroom)</li>
        </ul>
    </div>
    <h3>1.2.6 / 1.2.7 (19.01.2012)</h3>

    <div>
        <ul>
            <li>more CUL_HM devices (smoke sensor)</li>
            <li>fast scrolling in room detail views</li>
            <li>FHT desired-temp charting bug</li>
            <li>Fixed not updating overview boxes</li>
        </ul>
    </div>
    <h3>1.2.5 (18.01.2012)</h3>

    <div>
        <ul>
            <li>add a timeout for Telnet and FHEMWEB connections</li>
        </ul>
    </div>
    <h3>1.2.4 (17.01.2012)</h3>

    <div>
        <ul>
            <li>add desired-temp to the FHT graph</li>
            <li>fix CUL_WS temperature graph</li>
        </ul>
    </div>
    <h3>1.2.3 (17.01.2012)</h3>

    <div>
        <ul>
            <li>try to fix the update window issue</li>
        </ul>
    </div>
    <h3>1.2.2 (17.01.2012)</h3>

    <div>
        <ul>
            <li> bugfixes for FHEMWEB, Android 2.1</li>
        </ul>
    </div>
    <h3>1.2.1 (16.01.2012)</h3>

    <div>
        <ul>
            <li>device definition attributes in device detail views</li>
            <li>add FHEMWEB as data source</li>
            <li>add support for basic authentication via FHEMWEB</li>
            <li>repair a bug about not disappearing messages on update error</li>
        </ul>
    </div>
    <h3>1.2.0 (16.01.2012)</h3>

    <div>
        <ul>
            <li>fix update issue in FHEM timetable view</li>
            <li>bug fix (collapsing app if update process fails)</li>
            <li>bug fix (negative temperatures in charts)</li>
        </ul>
    </div>
    <h3>1.1.9 (13.01.2012)</h3>

    <div>
        <ul>
            <li>Bugfix: FHT mode attribute was not set</li>
        </ul>
    </div>
    <h3>1.1.8 (12.01.2012)</h3>

    <div>
        <ul>
            <li>view status of CUL_HM heating devices</li>
            <li>no longer forget changed start and end date when changing the screen
                rotation within the charting view
            </li>
            <li>various bug fixes</li>
        </ul>
    </div>
    <h3>1.1.7 (11.01.2012)</h3>

    <div>
        <ul>
            <li>bug fixes</li>
        </ul>
    </div>
    <h3>1.1.6 (10.01.2012)</h3>

    <div>
        <ul>
            <li>fix FS20 dim state issue (state = dimdown produced an exception)</li>
            <li>let some more errors fall through. This will produce more application
                crashes, but give me some more hints what is going wrong. If the
                application crashed, please always click on the "report" button.
            </li>
            <li>more device list xml validation</li>
            <li>refactor complete backend</li>
            <li>basic CUL_HM support (dim devices and switches)</li>
        </ul>
    </div>
    <h3>1.1.5 (07.01.2012)</h3>

    <div>
        <ul>
            <li>fix night temp issue</li>
            <li>change layout for detail devices (did not scroll)</li>
        </ul>
    </div>
    <h3>1.1.4 (07.01.2012)</h3>

    <div>
        <ul>
            <li>fix an issue when not changing the graph timespan</li>
            <li>switch FS20 and SIS_PMS devices from home screen</li>
        </ul>
    </div>
    <h3>1.1.3 (06.01.2012)</h3>

    <div>
        <ul>
            <li>fix for not working window open temperature</li>
            <li>dynamically change start and end dates in charts</li>
        </ul>
    </div>
    <h3>1.1.2 (05.01.2012)</h3>

    <div>
        <ul>
            <li>change FHT night temp, day temp and window open temp</li>
        </ul>
    </div>
    <h3>1.1.1 (05.01.2012)</h3>

    <div>
        <ul>
            <li>change FHT timetable</li>
        </ul>
    </div>
    <h3>1.1.0 (04.01.2012)</h3>

    <div>
        <ul>
            <li>urgent bugfix</li>
        </ul>
    </div>
    <h3>1.0.9 (04.01.2012)</h3>

    <div>
        <ul>
            <li>FHT: allow non comma values to be set as desired-temp</li>
            <li>show timetable for FHT control</li>
        </ul>
    </div>
    <h3>1.0.8 (03.01.2012)</h3>

    <div>
        <ul>
            <li>FHT control (mode and desired temperature)</li>
        </ul>
    </div>
    <h3>1.0.7 (03.01.2012)</h3>

    <div>
        <ul>
            <li>Rebuild FHEM commands to run asynchronously</li>
            <li>Remove method not found exception (java utility method not found)</li>
            <li>Repair dummy data graphing</li>
            <li>Set alias</li>
        </ul>
    </div>
    <h3>1.0.6 (02.01.2012)</h3>

    <div>
        <ul>
            <li>Show the update dialogue only if necessary</li>
        </ul>
    </div>
    <h3>1.0.5 (01.01.2012)</h3>

    <div>
        <ul>
            <li>Refresh the status of FS20 devices in detail view</li>
            <li>Bugfix: set desired-temp attribute</li>
            <li>Bugfix: set dewpoint attribute</li>
            <li>Measure time and room for all devices in detail view</li>
            <li>Detail view for USBWX devices</li>
            <li>Display data for OWCOUNT, OWFS, LGTV, RFXCOM and CUL_EM devices</li>
            <li>Display the previous state of RFXX10REC and CUL_FHTTK devices</li>
            <li>Move devices to other rooms</li>
        </ul>
    </div>
    <h3>1.0.4 (31.12.2011)</h3>

    <div>
        <ul>
            <li>Bugfix: App collapses whenever the device list contains devices not
                beeing associated to a room
            </li>
        </ul>
    </div>
    <h3>1.0.3 (31.12.2011)</h3>

    <div>
        <ul>
            <li>Bugfix: FS20 detail view switch bug</li>
            <li>Execute dialogue when dimming FS20 devices</li>
            <li>Only display set device attributes</li>
            <li>Better dummy data</li>
            <li>More attributes for OREGON devices (wind, rain, UV)</li>
        </ul>
    </div>
    <h3>1.0.2 (30.12.2011)</h3>

    <div>
        <ul>
            <li>Support for RFXX10REC, USBWX devices</li>
            <li>Bug in FS20 detail view (Button will not switch)</li>
            <li>Updates under the hood</li>
        </ul>
    </div>
    <h3>1.0.1 (30.12.2011)</h3>

    <div>
        <ul>
            <li>Bugfix: Error when hiding the update dialogue</li>
            <li>Support for umlauts (äöüß)</li>
            <li>Support for OREGON devices</li>
            <li>Support for displaying device names using the alias attribute</li>
        </ul>
    </div>
    <h3>1.0 (29.12.2011)</h3>

    <div>
        <ul>
            <li>Display devices in rooms</li>
            <li>Associate devices to favorites</li>
            <li>Switch and dim FS20 devices, switch SIS_PMS devices</li>
            <li>Display values for CUL_FHTTK, CUL_WS, HMS, KS300, FHT, OWTEMP devices
            </li>
            <li>Generate plots for CUL_WS, HMS, KS300 devices</li>
            <li>Delete and rename devices</li>
        </ul>
    </div>
</div>
