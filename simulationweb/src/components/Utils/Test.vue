<template>
  <v-container>
    <v-row align="center">
      <v-col>
        <h2>Connected</h2>
        <div>
          <v-btn color="primary" @click="tickleConnection">{{ connected ? 'disconnect' : 'connect' }}</v-btn>
        </div>
        <h2>Send Message</h2>
        <div>
          <v-text-field v-model="send_message" placeholder="Send Message"/>
          <v-btn class="is-rounded" @click="send">Send</v-btn>
        </div>
        <h2>Message Received</h2>
        <p>{{ received_messages }}</p>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

export default {
  name: 'home',
  data () {
    return {
      received_messages: [],
      send_message: null,
      connected: true
    }
  },
  methods: {
    send () {
      // eslint-disable-next-line
      console.log('Send message:' + this.send_message)
      if (this.stompClient && this.stompClient.connected) {
        this.stompClient.send('/app-receive/from-client', this.send_message, {})
      }
    },
    connect () {
      this.socket = new SockJS('http://localhost:8090/websocket-endpoint')
      this.stompClient = Stomp.over(this.socket)
      this.stompClient.connect({}, (frame) => {
        this.connected = true
        // eslint-disable-next-line
        console.log(frame)
        this.stompClient.subscribe('/global-message/tick', (tick) => {
          // eslint-disable-next-line
          console.log(tick)
          this.received_messages.push(tick)
        })
      }, (error) => {
        // eslint-disable-next-line
        console.log(error)
        this.connected = false
      })
    },
    disconnect () {
      if (this.stompClient) {
        this.stompClient.disconnect()
      }
      this.connected = false
    },
    tickleConnection () {
      this.connected ? this.disconnect() : this.connect()
    }
  },
  mounted () {
    this.connect()
  }
}
</script>
