RichPushSample
==============

RichPushSample is an example implementation of Rich Push for Android, using the
latest Urban Airship client library. You can use this sample for playing with
Rich Push, or as a reference point for integrating Rich Push into your own project.


Android Studio Setup
--------------------

1) Update the Android SDK Manager
    - Verify Android Support Repository and Google Repository (under Extras) are installed and up-to-date

2) Download the Android/Amazon library from http://urbanairship.com/resources/developer-resources

3) Copy the urbanairship-lib-*.aar file into RichPushSample/aars/

4) Import the project into Android Studio
    - Open Android Studio to welcome screen
    - Import project, select the Samples root directory

5) Update AirshipConfig.properties file with your application's configuration
    - Amazon setup docs http://docs.urbanairship.com/build/push/android.html#adm-setup
    - GCM setup docs http://docs.urbanairship.com/build/push/android.html#gcm-setup

6) Build and run the Rich Push Sample


Eclipse (ADT) Setup
-------------------

1) Update the Android SDK Manager
    - Verify Android Support Library and Google Play Services (under Extras) are installed and up-to-date

2) Download the Android/Amazon library from http://urbanairship.com/resources/developer-resources

3) Import projects
    - Eclipse -> Import Android Project -> Samples/PushSample
    - Eclipse -> Import Android Project -> urbanairship-lib (from download)

4) Add the Urban Airship library project as a dependency
    - Follow http://developer.android.com/tools/projects/projects-eclipse.html#ReferencingLibraryProject

5) Add the v4 and v7 Support library as dependencies
    - Follow http://developer.android.com/tools/support-library/setup.html

6) (GCM Only) Set up Google Play services
    - http://developer.android.com/google/play-services/setup.html#Setup

7) Update AirshipConfig.properties file with your application's configuration
    - Amazon setup docs http://docs.urbanairship.com/build/push/android.html#adm-setup
    - GCM setup docs http://docs.urbanairship.com/build/push/android.html#gcm-setup

8) Build and run the Rich Push Sample


Further Reading
---------------

For more information on using Rich Push for Android see our documentation_ site.

.. _documentation: http://docs.urbanairship.com


Sample App Components
---------------------

Source files
^^^^^^^^^^^^

AbstractInboxFragment.java
   An abstract class that implements the basic functionality for a rich push inbox.

AddTagsPreference.java
   DialogPreference to add the tags.

CustomSlidingPaneLayout.java
   Sliding pane layout that only allows sliding if the slide gesture originates from a gutter.

CustomViewPager.java
   A ViewPager that allows touch events to be enabled and disabled.

InboxActivity.java
   * Displays the InboxFragment.
   * If application is on a phone, will show just the InboxFragment and launch MessageActivity when a message is selected.
   * If application is on a tablet, will show the InboxFragment as a pane on the left and the MessagePagerFragment as a pane on the right.

InboxFragment.java
   An AbstractInboxFragment that shows the inbox with an action mode.

InboxNotificationBuilder.java
   A custom push notification builder to create inbox style notifications for rich push messages.

MessageActivity.java
   A simple Activity that displays a MessagePagerFragment.  This is only used on phones.

MessageFragment.java
   A Fragment that contains a WebView that displays the contents of the RichPushMessage.

MessagePagerFragment.java
   A Fragment that shows MessageFragments in a view pager.

MessageFragmentAdapter.java
   A FragmentAdapter for a ViewPager that displays rich push messages.

ParseDeepLinkActivity.java
   An activity that handles parsing deep links.

PushPreferencesActivity.java
   Displays the preferences.

PushReceiver.java
   Broadcast receiver to handle all push notifications.

RichPushApplication.java
   The main Rich Push application.

RichPushMessageDialogFragment.java
   Dialog Fragment that displays a rich push message. This is used to display a message in a dialog in the MainActivity.

RemoteViewsFactory.java
   Factory class to create remote views for the widget layouts.

RichPushWidgetProvider.java
   The widget provider for the rich push inbox.

RichPushWidgetService.java
   Service that provides the factory to be bound to the collection service.

SetAliasPreference.java
   DialogPreference to set the alias.

ViewBinderArrayAdapter.java
   A generic base adapter that binds items to views using the ViewBinder interface.


Resources
^^^^^^^^^^^^

layout/cab_selection_dropdown.xml
   The select all/deselect all action item in the Inbox CAB.

layout/inbox_activity.xml
   Layout for the inbox activity.

layout/inbox_list_item.xml
   Layout for the inbox line items.

layout/landing_page_activity
   Custom landing page layout.

layout/main_activity.xml
   Layout for MainActivity.

layout/message_activity.xml
   Layout for MessageActivity.

layout/message_dialog.xml
   Layout for the RichPushMessageDialogFragment.

layout/message_fragment.xml
   Layout for MessageFragments.

layout/message_pager_fragment.xml
   Layout for the MessagePagerFragment.

layout/tag_preference_item.xml
   Layout for the tag preference.

layout/tags_dialog_layout.xml
   Layout for the dialog to set or delete tags.

layout/widget_item.xml
   Layout for an inbox line item in the large widget layout.

layout/widget_layout_small.xml
   The small widget inbox layout with an unread message count.

layout/widget_layout.xml
   The large widget inbox layout with a list of messages.

layout-sw600dp/inbox_activity.xml
   InboxFragment layout for large screen devices (600dp and higher).

menu/inbox_actions_menu.xml
   Menu of items that appear in the action bar when a message is selected in the InboxActivity.

menu/inbox_menu.xml
   Menu of items that appear along the top of the action bar when no message is selected in the InboxActivity.

menu/main_menu.xml
   Menu items that appear in the action bar in the MainActivity.

menu/message_activity.xml
   Menu items that appear in the action bar in the MessageActivity.

menu/selection.xml
   Menu items that appears for the select/deselect all action item.

values/dimens.xml
   Defines the default layout dimensions for the widget margin.

values-v14/dimens.xml
   Defines the api 14 and above layout dimensions for the widget margin.

values/strings.xml
   Defines all the string resources.

xml/advanced_preferences.xml
   Defines the preferences for APID, Rich Push User, setting tags and aliases.

xml/location_preferences.xml
   Defines the preferences for location settings.

xml/push_preferences.xml
   Defines the preferences for push settings.

xml/widgetinfo.xml
   Defines the inbox widget information for devices api 10 and below.

xml-v11/widgetinfo.xml
   Defines the inbox widget information for devices api 11 and above.

