# gruppeprosjekt-19

# 7.0 Prototype


Vi bestemte oss for at vi ville bruke Java og lage en enkel prototype ved å bruke terminalen til de ulike oppgavene som skal bli utført av programmet. Prototypen bruker Java-versjon 20.

Prototypen vår er brukervennlig, hvor du får utskrift av hva som trengs fra brukeren for at programmet skal kjøre de ulike funksjonene. Dette kan være å logge inn på de ulike kontoene, registrere en bruker/guide og få en liste med turer. 

For å først starte programmet må du gå til Main og kjøre programmet, og under går vi gjennom hvordan programmet fungerer. 

For å kjøre testene må du gå til test-mappen og høyreklikke på java-mappen. Deretter velger du Run ‘Tests in java’.


## 7.1 Systemarkitektur 

Nedenfor finner du et klassediagram som illustrerer strukturen til prototypen vår. Dette diagrammet ble opprettet for å presentere oppbyggingen og de ulike sammenhengene i systemet, samt hvordan det skal reagere under bruk. 

![image16](https://github.com/sakariam/gruppeprosjekt-19/assets/83866259/64af8dd4-eef3-45ea-b647-50e367814aea)

## 7.2 Login/Start

Når du først starter programmet så vil du få en oversikt over hva du kan logge deg inn som, Admin, Guide og User. For å navigere seg i programmet så må brukeren skrive inn tallet som står på hver av de ulike funksjonene som brukeren vil kjøre. Du kan se et eksempel på hvordan det ser ut under *Admin Figur 7.3.1.*
## 7.3 Admin
Om du skriver inn tallet 1 så vil du logge deg inn som Admin og vil du bli møtt med dette i terminalen:

![image1](https://github.com/sakariam/gruppeprosjekt-19/assets/83866259/74e7e92f-5745-4ad4-8128-7414353515eb)

<sub>*Figur 7.3.1. Illustrasjon av Admin funksjoner*</sub>

Adminen er den eneste som får lagt til og slettet guider i prototypen, men i det ferdige produktet vil guiden også få mulighet til å slette sin egen konto. Admin får også en oversikt over hver av guidene og hvilke turer de har opprettet. 
## 7.4 Guide
Når du skriver inn 2 i login vil du få opp en meny hvor du får logget deg inn som en guide som allerede har blitt opprettet av Admin.

![image9](https://github.com/sakariam/gruppeprosjekt-19/assets/83866259/8acd1741-c134-4cfa-843f-f4a93470d65c)

<sub>*Figur 7.4.1 Illustrasjon av guide login*</sub>

Etter du velger hvilken guide du vil logge deg inn vil du få en oversikt over hvilke funksjoner guiden har, som sett under i figur 7.3.2. Guiden får muligheten til å legge til turer, vise sine turer og fjerne dem. For å gjennomføre de ulike funksjonene må man følge instruksjonene som blir gitt av programmet.

![image14](https://github.com/sakariam/gruppeprosjekt-19/assets/83866259/4a6ba8e7-5d52-4e50-8d81-87cebfa7cac2)

<sub>*Figur 7.4.2 Illustrasjon av guide meny*</sub>
## 7.5 User
Etter du skriver inn <3> vil du få muligheter til å lage en profil og velge hvilken konto du vil logge deg inn med.

![image11](https://github.com/sakariam/gruppeprosjekt-19/assets/83866259/bf915d79-4400-479b-a5d1-9a79278bbc17)

<sub>*Figur 7.5.1 Illustrasjon av Bruker registrering/login*</sub>

Etter du velger en konto vil du få en brukermeny for å kunne bestille turer og se på hvilke turer du har kjøpt. Når du bestiller en tur vil du få opp en liste med alle turer som en guide har laget. Også vil du ha muligheten til å slette kontoen sin.

![image18](https://github.com/sakariam/gruppeprosjekt-19/assets/83866259/cc9e977c-3216-4c16-9f8d-2cd63775616d)

<sub>*Figur 7.5.2 Illustrasjon av Bruker meny*</sub>
## 7.6 Svakheter
### 7.6.1 Valg 
I Prototypen så vil den krasje/avslutte om brukeren skriver noe prototypen ikke forventer. Dette skjer f.eks i start siden hvor hvis du skriver inn bokstaver så vil programmet få en error. For å fikse dette ville vi puttet koden i en løkke for å gi brukeren en ny sjanse.

### 7.6.2 Legge inn data
Når det kreves at brukeren skal legge inn et tall. F.eks når du skal legge inn pris på turen så vil programmet krasje om brukeren legger inn noe som ikke er et tall. For å fikse det kan man be brukeren om å prøve på nytt og legge inn et tall istedenfor ved å loope tilbake til start. 

### 7.6.3 Lagring av data
Når brukeren skriver inn data så vil ikke noe bli lagret før all dataen som kreves blir lagt inn. Om vi hadde hatt en nettside så kunne vi brukt javascript og localstorage for å jevnlig lagre data inne i serveren eller lokal lagring for å unngå at brukeren mister det de har skrevet.

### 7.6.4 Testing
Vi støttet på en del problemer når det kommer til testing. Testing av Controller-klassen ble vanskelig å få til ettersom inputen ikke klarte å få med seg all data slik at testingen kunne fullføres. En mulig løsning på dette kunne ha vært å ha lagd en instansvariabel for scanner og bare ha en scanner, men dette fikk vi ikke til. Vi har kommentert ut to filer der vi forsøker å teste, men feiler. 

