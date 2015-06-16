/*
Copyright 2009-2014 Urban Airship Inc. All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE URBAN AIRSHIP INC ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
EVENT SHALL URBAN AIRSHIP INC OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.urbanairship.richpush.sample;

import android.app.Application;
import android.content.Intent;

import com.urbanairship.UAirship;
import com.urbanairship.richpush.RichPushInbox;
import com.urbanairship.richpush.sample.widget.RichPushWidgetProvider;

public class RichPushApplication extends Application {

    public static final String EXTRA_OPEN_MESSAGE_ID = "com.urbanairship.richpush.sample.EXTRA_OPEN_MESSAGE_ID";

    public static final String HOME_ACTIVITY = "Home";
    public static final String INBOX_ACTIVITY = "Inbox";
    public static final String[] navList = new String[] {
            HOME_ACTIVITY, INBOX_ACTIVITY
    };

    @Override
    public void onCreate() {
        UAirship.takeOff(this, new UAirship.OnReadyCallback() {
            @Override
            public void onAirshipReady(UAirship airship) {
                // Set the custom notification factory
                airship.getPushManager().setNotificationFactory(new RichPushNotificationFactory(RichPushApplication.this));

                // Refresh the widget when the inbox changes
                airship.getRichPushManager().getRichPushInbox().addListener(new RichPushInbox.Listener() {
                    @Override
                    public void onUpdateInbox() {
                        refreshWidget();
                    }
                });
            }
        });
    }

    /**
     * Sends a request to refresh the rich push message widget
     */
    private void refreshWidget() {
        Intent refreshIntent = new Intent(this, RichPushWidgetProvider.class)
                .setAction(RichPushWidgetProvider.REFRESH_ACTION);

        this.sendBroadcast(refreshIntent);
    }
}
