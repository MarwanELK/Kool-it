const { default: GoogleLogin } = require("react-google-login");

// script.js
function script() {
    const responseGoogle  = response => {
        console.log(response)
    }

    const responseError  = error => {
        console.log(error) 
    }

return (
    <div>
        <div className='App'>
            <h1>Google Calendar API</h1>
    </div>
    <div>
        <GoogleLogin
        clientId='954582597122-culbj6alb423i7bjr0sile2j47ttq8dt.apps.googleusercontent.com'
        buttonText='Sign in and Auhorize Calendar'
        onSuccess={responseGoogle}
        onFailure={responseError}
        cookiePolicy={'single_host_origin'}
        responseType='code'
        accessType='offline'
        scope='openid email profile https://www.googleapis.com/auth/calendar'
        />
    </div>
    </div>
)

}
