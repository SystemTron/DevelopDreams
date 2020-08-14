import React from 'react';
import firebase from 'firebase'
import fire from '../../config/fire';
import { Grid, Button, Divider } from '@material-ui/core';
import GoogleButton from 'react-google-button';
import Typography from '@material-ui/core/Typography';


const SignIn = (props) => {

    const handle_click = () => {
        const provider = new firebase.auth.GoogleAuthProvider()
        fire.auth().signInWithPopup(provider).then(function(result) {
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
        <Typography component="h1" variant="h5" style={{display: "flex", justifyContent: "center",alignItems:"center",paddingBottom:"20px"}}>
          OR
        </Typography>
       
          <GoogleButton onClick={handle_click} style={{}} />
        </Grid>
    )
}

export default SignIn