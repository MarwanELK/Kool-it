const CLIENT_ID = 
"954582597122-gotb1ibve9ktjlon1ekcg7t40h22s98i.apps.googleusercontent.com";
const API_KEY = "AIzaSyAXLKoRXbggAfRkeMtvbYZSgdrQRgHU01w";
const DISCOVERY_DOC = 
"https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest";
const SCOPES = "https://www.googleapis.com/auth/calendar";
let tokenClient;
let gapiInited = false;
let gisInited = false;

function gapiLoaded(){
    gapi.load("client", initializeGapiClient);
}

async function initializeGapiClient(){
    await gapi.client.init({
        apiKey: API_KEY,
        discoveryDocs: [DISCOVERY_DOC],
    });
    gapiInited = true;
}

function gisLoaded(){
    tokenClient = google.accounts.oauth2.initTokenClient({
        client_id: CLIENT_ID,
        scope: SCOPES,
        callback: "", 
    });
    gisInited = true;
}

function createGoogleEvent(eventDetails){

    tokenClient.callback = async (resp) => {
        if(resp.error !== undefined){
            throw resp;
        }
        await scheduleEvent(eventDetails);
    };
    if (gapi.client.getToken() === null){
        tokenClient.requestAccessToken({ prompt: "consent"});
    } else {
        tokenClient.requestAccessToken({ prompt: ""});
    }
}

function scheduleEvent(eventDetails){
    const event = {
        summary: eventDetails.summary,
        location: "Europe/Paris",
        description: "Un évènements créer depuis l'application Koolit!!",
        start: {
            dateTime: eventDetails.startTime,
            timeZone: "Europe/Paris",
        },
        end: {
            dateTime: eventDetails.endTime,
            timeZone: "Europe/Paris",
        },
        recurrence: ["RRULE:FREQ=DAILY;COUNT=1"],
        attendees : [{email: eventDetails.email}],
        reminders: {
            useDefault: false,
            overrides : [
                { method: "email", minutes: 24 * 60},
                { method: "popup", minutes: 10},
            ],
        },
    };
    const request = gapi.client.calendar.events.insert({
        calendarId: "primary",
        resource: event,
    });
    request.execute(function (event) {
        console.info("Event created :" + event.htmlLink);
    });
}