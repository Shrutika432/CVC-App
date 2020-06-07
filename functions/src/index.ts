import * as functions from "firebase-functions";
import * as admin from "firebase-admin";

admin.initializeApp();
const fcm = admin.messaging();

export const sendNotificationOnEventCreated = functions.firestore
  .document("events/{eventId}")
  .onCreate((snapshot) => {
    const event = snapshot.data();
    const payload: admin.messaging.MessagingPayload = {
      notification: {
        title: "New Event is added!",
        body: `${event.eventdec} is scheduled at ${event.eventdate}, check event module to volunteer in!`,
        icon: "https://image.flaticon.com/icons/svg/2959/2959559.svg",
      },
    };

    return fcm.sendToTopic("all", payload);
  });
