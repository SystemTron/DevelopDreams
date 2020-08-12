import React from 'react';
import firebase from 'firebase'
import fire from '../config/fire';
import { Grid, Button } from '@material-ui/core';

const SignIn = (props) => {

    const handle_click = () => {
        const provider = new firebase.auth.GoogleAuthProvider()
        firebase.auth().signInWithPopup(provider).then(function(result) {
            // This gives you a Google Access Token. You can use it to access the Google API.
            var token = result.credential.accessToken;
            // The signed-in user info.
            var user = result.user;
            // ...
          }).catch(function(error) {
            // Handle Errors here.
            var errorCode = error.code;
            var errorMessage = error.message;
            // The email of the user's account used.
            var email = error.email;
            // The firebase.auth.AuthCredential type that was used.
            var credential = error.credential;
            // ...
          });
    }

    return (
        <Grid>
        <Button onClick = {handle_click} variant = "h6" style = {{color:"white"}}>Sign In</Button>
        
        </Grid>
    )
}

export default SignIn