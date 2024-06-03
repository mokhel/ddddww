package furhatos.app.douliker.flow.main

import furhatos.app.douliker.flow.*  // Importiere alle Elemente aus dem douliker.flow Paket
import furhatos.flow.kotlin.*  // Importiere alle notwendigen Elemente aus der furhatos.flow.kotlin Bibliothek
import furhatos.gestures.Gestures  // Importiere Gestures für Gestensteuerung
import furhatos.nlu.common.*  // Importiere gebräuchliche Natural Language Understanding Klassen
import furhatos.util.Language  // Importiere Language für Sprachunterstützung


// Hauptdialogzustand Greeting
val Greeting: State = state(Parent) {  // Definiere einen Zustand namens Greeting, der von einem Elternzustand erbt
    onEntry {  // Aktion beim Eintritt in den Zustand
        furhat.setInputLanguage(Language.GERMAN)
        furhat.ask("Hi there")  // Furhat fragt den Benutzer "Hi there"
    }
    onResponse<Goodbye> {  // Falls die Antwort des Benutzers vom Typ Goodbye ist
        furhat.say("Goodbye")  // Furhat sagt "Goodbye"
        goto(Idle)  // Wechsel in den Zustand Idle
    }
    onResponse {  // Reaktion auf jede Antwort des Benutzers
        val robotResponse = call {  // Ruft eine Funktion auf, um eine Antwort zu generieren
            getDialogCompletion()
        } as String?  // Castet das Ergebnis zu einem String
        furhat.ask(robotResponse ?: "Entschuldigung, ich höre dich nicht")  // Furhat fragt mit der erhaltenen Antwort oder "Entschuldigung, ich höre dich nicht" wenn die Antwort null ist
    }

    onNoResponse {  // Falls keine Antwort vom Benutzer kommt
        furhat.ask("Entschuldigung, ich höre dich nicht")  // Furhat fragt "Entschuldigung, ich höre dich nicht"
    }
}
