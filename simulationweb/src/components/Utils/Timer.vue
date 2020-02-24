<template>
   <v-row justify="center">
      <v-col>
         <div class="bus">
            <div class="windows"></div>
            <div class="lights"></div>
            <div class="street"></div>
         </div>
         <section class="countdown">
            <div v-show="!expired" class="timer">
               <div class="box">
                  <div class="spacer"></div>
                  <p class="value">{{ theTime.days }}</p>
                  <p class="label">days</p>
               </div>
               <div class="box">
                  <div class="spacer"></div>
                  <p class="value">{{ theTime.hours }}</p>
                  <p class="label">hours</p>
               </div>
               <div class="box">
                  <div class="spacer"></div>
                  <p class="value">{{ theTime.minutes }}</p>
                  <p class="label">minutes</p>
               </div>
               <div class="box">
                  <div class="spacer"></div>
                  <p class="value">{{ theTime.seconds }}</p>
                  <p class="label">seconds</p>
               </div>
               <p class="text">before Japan</p>
            </div>

            <div v-show="expired" class="expired-timer timer">
               <div class="box">
                  <div class="spacer"></div>
                  <p class="value">It's the great day</p>
                  <p class="label">Go To the Fucking JAPAN</p>
               </div>
            </div>
         </section>
      </v-col>
   </v-row>
</template>

<script>
   export default {
      data() {
         return{
            deadline: 'Apr 14, 2020 00:00:00',
            days: 'HI',
            hours: 'TH',
            minutes: 'ER',
            seconds: 'E!',
            expired: false
         };
      },

      computed: {
         theTime(){
            var ctx = this;

            // Countdown loop
            // eslint-disable-next-line
            var x =  setInterval(() => {

               // Difference between the 2 dates
               var countDownDate = new Date(ctx.deadline).getTime(),
                  now = new Date().getTime(),
                  diff = countDownDate - now,

                  // Time conversion to days, hours, minutes and seconds
                  tdays = Math.floor(diff / (1000 * 60 * 60 * 24)),
                  thours = Math.floor((diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)),
                  tminutes = Math.floor((diff % (1000 * 60 * 60)) / (1000 * 60)),
                  tseconds = Math.floor((diff % (1000 * 60)) / 1000);

               // Keep 2 digits
               ctx.days = (tdays < 10) ? '0' + tdays : tdays;
               ctx.hours = (thours < 10) ? '0' + thours : thours;
               ctx.minutes = (tminutes < 10) ? '0' + tminutes : tminutes;
               ctx.seconds = (tseconds < 10) ? '0' + tseconds : tseconds;

               // Check for time expiration
               if(diff < 0){
                  clearInterval(x);
                  ctx.expired = true;
               }
            }, 1000);

            // Return data
            return {
               days: ctx.days,
               hours: ctx.hours,
               minutes: ctx.minutes,
               seconds: ctx.seconds
            };
         }
      }
   }
</script>
<style>
   @import url("https://fonts.googleapis.com/css?family=Graduate|Quicksand:300,400,700");
   *,
   *::before,
   *::after {
      box-sizing: border-box;
   }

   .countdown {
      text-align: center;
   }

   .timer {
      -webkit-perspective: 1000px;
      perspective: 1000px;
   }
   .timer .box {
      display: inline-block;
      margin: 1rem;
      width: 10rem;
      text-align: center;
      background: #e5989b;
      -moz-transform-style: preserve-3d;
   }
   .timer .box:nth-child(2) .value {
      -webkit-animation-delay: 1s;
      animation-delay: 1s;
   }
   .timer .box:nth-child(3) .value {
      -webkit-animation-delay: 1.8s;
      animation-delay: 1.8s;
   }
   .timer .box:nth-child(4) .value {
      -webkit-animation-delay: 1.3s;
      animation-delay: 1.3s;
   }
   .timer .box:nth-child(5) .value {
      -webkit-animation-delay: 2s;
      animation-delay: 2s;
   }
   .timer .box .spacer {
      position: relative;
      content: "";
      display: block;
      height: 20px;
      background: #ffb4a2;
   }
   .timer .box .spacer::before, .timer .box .spacer::after {
      content: "";
      position: absolute;
      top: 5px;
      width: 10px;
      height: 10px;
      background: #ffcdb2;
      border-radius: 50%;
   }
   .timer .box .spacer::before {
      left: 0.8rem;
   }
   .timer .box .spacer::after {
      right: 0.8rem;
   }
   .timer .box .value {
      position: relative;
      margin: 0;
      padding: 1.2rem 0 2rem;
      font-family: "Graduate", sans-serif;
      font-size: 3em;
      color: rgba(109, 104, 117, 0.6);
      background: #ffb4a2;
      -webkit-transform-origin: top center;
      transform-origin: top center;
      -webkit-animation: wind 4s ease-out alternate infinite;
      animation: wind 4s ease-out alternate infinite;
      box-shadow: 0 15px 10px -10px rgba(181, 131, 141, 0);
   }
   .timer .box .label {
      margin: 0;
      padding: 1rem;
      color: rgba(255, 255, 255, 0.8);
      background: #e5989b;
   }
   .timer .box .label::first-letter {
      text-transform: uppercase;
   }
   .timer .text {
      margin-top: 2rem;
      font-weight: 300;
      font-size: 1.25em;
      text-transform: uppercase;
      letter-spacing: 4px;
      text-align: center;
      color: #b5838d;
   }

   .expired-timer .box {
      width: 100%;
   }

   .bus {
      -webkit-transform: scale(0.8);
      transform: scale(0.8);
      position: relative;
      width: 120px;
      height: 100px;
      margin: 3rem auto 4rem;
      border-radius: 30px 30px 0 0;
      background: #6d6875;
   }
   .bus::before, .bus::after {
      content: "";
      position: absolute;
      top: 100%;
      width: 20px;
      height: 20px;
      border-radius: 0 0 2px 2px;
      background: #6d6875;
   }
   .bus::before {
      left: 0.5rem;
   }
   .bus::after {
      right: 0.5rem;
   }
   .bus .windows {
      position: absolute;
      top: 20px;
      left: 0.5rem;
      right: 0.5rem;
      height: 35px;
   }
   .bus .windows::before, .bus .windows::after {
      content: "";
      position: absolute;
      top: 0;
      width: 48%;
      height: 100%;
      background: rgba(255, 255, 255, 0.7);
   }
   .bus .windows::before {
      left: 0;
   }
   .bus .windows::after {
      right: 0;
   }
   .bus .lights {
      position: absolute;
      bottom: 10px;
      left: 0.5rem;
      right: 0.5rem;
      height: 10px;
   }
   .bus .lights::before, .bus .lights::after {
      content: "";
      position: absolute;
      top: 0;
      width: 10px;
      height: 10px;
      background: #ffb4a2;
      border-radius: 50%;
   }
   .bus .lights::before {
      left: 16px;
      box-shadow: -16px 0 0 2px rgba(255, 255, 255, 0.5), 14px 0 0 #e5989b;
      -webkit-animation: lighting 6s 2s linear infinite;
      animation: lighting 6s 2s linear infinite;
   }
   .bus .lights::after {
      right: 16px;
      box-shadow: 16px 0 0 2px rgba(255, 255, 255, 0.5), -14px 0 0 #e5989b;
      -webkit-animation: lighting2 6s 2s linear infinite;
      animation: lighting2 6s 2s linear infinite;
   }
   .bus .street {
      position: absolute;
      bottom: -30px;
      left: 50%;
      -webkit-transform: translateX(-50%);
      transform: translateX(-50%);
      width: 130px;
      height: 1px;
      background: rgba(181, 131, 141, 0.8);
   }
   .bus .street::before, .bus .street::after {
      content: "";
      position: absolute;
      height: 1px;
      left: 50%;
      -webkit-transform: translateX(-50%);
      transform: translateX(-50%);
   }
   .bus .street::before {
      top: 10px;
      width: 110px;
      background: rgba(181, 131, 141, 0.6);
   }
   .bus .street::after {
      top: 20px;
      width: 90px;
      background: rgba(181, 131, 141, 0.4);
   }

   @-webkit-keyframes wind {
      0% {
         -webkit-transform: rotatex(0);
         transform: rotatex(0);
         box-shadow: 0 15px 10px -10px rgba(181, 131, 141, 0);
         color: rgba(109, 104, 117, 0.6);
         background: #ffb4a2;
      }
      10% {
         -webkit-transform: rotatex(20deg);
         transform: rotatex(20deg);
         box-shadow: 0 15px 10px -10px #ab737e;
         color: rgba(109, 104, 117, 0.45);
         background: #ffc0b1;
      }
   }

   @keyframes wind {
      0% {
         -webkit-transform: rotatex(0);
         transform: rotatex(0);
         box-shadow: 0 15px 10px -10px rgba(181, 131, 141, 0);
         color: rgba(109, 104, 117, 0.6);
         background: #ffb4a2;
      }
      10% {
         -webkit-transform: rotatex(20deg);
         transform: rotatex(20deg);
         box-shadow: 0 15px 10px -10px #ab737e;
         color: rgba(109, 104, 117, 0.45);
         background: #ffc0b1;
      }
   }
   @-webkit-keyframes lighting {
      0% {
         box-shadow: -16px 0 0 2px rgba(255, 255, 255, 0.5), 14px 0 0 #e5989b;
      }
      4% {
         box-shadow: -16px 0 0 2px white, 14px 0 0 #e5989b;
      }
      8% {
         box-shadow: -16px 0 0 2px rgba(255, 255, 255, 0.5), 14px 0 0 #e5989b;
      }
      12% {
         box-shadow: -16px 0 0 2px white, 14px 0 0 #e5989b;
      }
      20% {
         box-shadow: -16px 0 0 2px white, 14px 0 0 #e5989b;
      }
      22% {
         box-shadow: -16px 0 0 2px rgba(255, 255, 255, 0.5), 14px 0 0 #e5989b;
      }
   }
   @keyframes lighting {
      0% {
         box-shadow: -16px 0 0 2px rgba(255, 255, 255, 0.5), 14px 0 0 #e5989b;
      }
      4% {
         box-shadow: -16px 0 0 2px white, 14px 0 0 #e5989b;
      }
      8% {
         box-shadow: -16px 0 0 2px rgba(255, 255, 255, 0.5), 14px 0 0 #e5989b;
      }
      12% {
         box-shadow: -16px 0 0 2px white, 14px 0 0 #e5989b;
      }
      20% {
         box-shadow: -16px 0 0 2px white, 14px 0 0 #e5989b;
      }
      22% {
         box-shadow: -16px 0 0 2px rgba(255, 255, 255, 0.5), 14px 0 0 #e5989b;
      }
   }
   @-webkit-keyframes lighting2 {
      0% {
         box-shadow: 16px 0 0 2px rgba(255, 255, 255, 0.5), -14px 0 0 #e5989b;
      }
      4% {
         box-shadow: 16px 0 0 2px white, -14px 0 0 #e5989b;
      }
      8% {
         box-shadow: 16px 0 0 2px rgba(255, 255, 255, 0.5), -14px 0 0 #e5989b;
      }
      12% {
         box-shadow: 16px 0 0 2px white, -14px 0 0 #e5989b;
      }
      20% {
         box-shadow: 16px 0 0 2px white, -14px 0 0 #e5989b;
      }
      22% {
         box-shadow: 16px 0 0 2px rgba(255, 255, 255, 0.5), -14px 0 0 #e5989b;
      }
   }
   @keyframes lighting2 {
      0% {
         box-shadow: 16px 0 0 2px rgba(255, 255, 255, 0.5), -14px 0 0 #e5989b;
      }
      4% {
         box-shadow: 16px 0 0 2px white, -14px 0 0 #e5989b;
      }
      8% {
         box-shadow: 16px 0 0 2px rgba(255, 255, 255, 0.5), -14px 0 0 #e5989b;
      }
      12% {
         box-shadow: 16px 0 0 2px white, -14px 0 0 #e5989b;
      }
      20% {
         box-shadow: 16px 0 0 2px white, -14px 0 0 #e5989b;
      }
      22% {
         box-shadow: 16px 0 0 2px rgba(255, 255, 255, 0.5), -14px 0 0 #e5989b;
      }
   }
   @media screen and (max-width: 800px) {
      .countdown {
         width: 100%;
         max-width: 25rem;
      }
   }
   @media screen and (max-width: 480px) {
      .timer .box {
         margin: 1rem 0.5rem;
         width: 8rem;
      }

      .expired-timer .box {
         width: 18rem;
      }
   }
</style>