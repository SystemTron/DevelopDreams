import firebase, { initializeApp } from 'firebase'

const firebaseConfig = {
    apiKey: "AIzaSyDUjU2Ulxx5aCLNJnic8TcSRtTN4p-hwyc",
    authDomain: "developdreams-d6909.firebaseapp.com",
    databaseURL: "https://developdreams-d6909.firebaseio.com",
    projectId: "developdreams-d6909",
    storageBucket: "developdreams-d6909.appspot.com",
    messagingSenderId: "107774544708",
    appId: "1:107774544708:web:81615aa0a30cbb893ce511",
    measurementId: "G-YQD57KLTC2"
  };

let fire = initializeApp(firebaseConfig);

export default fire