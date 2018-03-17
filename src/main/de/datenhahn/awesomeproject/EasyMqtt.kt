/*
MIT License

Copyright (c) 2018 Jonas Hahn <jonas.hahn@datenhahn.de>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package de.datenhahn.awesomeproject

import com.github.sylvek.embbededmosquitto.Mosquitto
import de.datenhahn.easymqtt.EasyMqtt

fun main(args: Array<String>) {
    println("Starting example server")
    Mosquitto.getInstance().start()

    val client = EasyMqtt()
    client.subscribe("easymqtt/example", onMessage = { topic, message -> println(topic + " | " + message) })
    client.publish("easymqtt/example", "MQTT is easy!")
    client.disconnect()
}