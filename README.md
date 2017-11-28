# Lukuvinkkikirjasto

[![Build Status](https://travis-ci.org/betallica/lukuvinkkikirjasto.svg?branch=master)](https://travis-ci.org/betallica/lukuvinkkikirjasto)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/14c41217b02346a285fc51be8267b262)](https://www.codacy.com/app/V-Kopio/lukuvinkkikirjasto?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=betallica/lukuvinkkikirjasto&amp;utm_campaign=Badge_Grade)
[![Code Coverage](https://api.codacy.com/project/badge/Coverage/14c41217b02346a285fc51be8267b262)](https://www.codacy.com/app/V-Kopio/lukuvinkkikirjasto?utm_source=github.com&utm_medium=referral&utm_content=betallica/lukuvinkkikirjasto&utm_campaign=Badge_Coverage)

## Linkkejä

- Heroku: [Production application](https://fast-sands-82937.herokuapp.com)

- Google Sheets: [Backlog](https://docs.google.com/spreadsheets/d/1I5ekYUIwwIMCS3j7zQsP_keDep6tV_8D772lOwKTHKE)

<!--- Google Slides: [Layouts & Functional description](https://docs.google.com/presentation/d/1s_RKYejlTn85c9iI1tOGxoGk3G4OnT2LkCz3LkncwVM/edit?usp=sharing) --->

## Sovelluskehitys
Suorita sovellus komennolla `gradle run`, käynnistyy osoitteeseen http://localhost:8080

Testit suoritetaan komennolla `gradle test`

Testit käyttävät _lib_-hakemistossa olevaa firefox Geckodriveriä

Konfiguraatiosta on kiittäminen kevään 2017 [TKT-FUBAR](https://github.com/TKT-FUBAR/Ohtu-miniprojekti)-miniprojektiryhmää.

### Frontend

Frontendin muokattavat tiedostot löytyvät hakemistosta `frontend/`. Omat Javascript- ja css-tiedostot sekä kolmannen osapuolen kirjastot kootaan yhdeksi 
tiedostoksi Springin `static/`-hakemistoon tiedostoiksi `js/app.js` ja `css/app.css` **Webpackin** avulla.

Tätä operaatiota varten tarvitaan [Node.js](https://nodejs.org/en/). Node asennettuna voidaan ladata kaikki riippuvuudet hakemistossa `frontend/` komennolla

    npm install

Projektin omat javascript- ja sass-tiedostot ovat hakemistossa `frontend/src/`. Muutokset tiedostoihin saadaan Springin käyttöön komennolla

    npm run build

#### Frameworks

Projektissa on käytössä [Bulma](https://bulma.io/)-css-framework, jonka kaikki dokumentaatiosta löytyvät assetit ovat käytettävissä.


## Definition of Done
User storyn mukainen toiminnallisuus on koodattu niin, että se toimii. Se on myös testattu, dokumentoitu ja integroitu (koodi on githubissa master-branchissa).
