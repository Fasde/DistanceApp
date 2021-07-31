# Spielort-Finder für Schiedsrichter Weser-Ems
### Arbeitstitel: DistanceApp
### App-Installationstitel: Spielort-Distanz

#### Einleitung
Diese App soll den Fußball-Schiedsrichtern aus dem NFV-Bezirk Weser-Ems, inklusive aller Kreise dieses
Bezirks helfen, die unzähligen Sportplätze in den verschiedenen Kreisen, Städten und Dörfern leicht zu
finden, sowie Informationen zu Route, Fahrtzeit, abrechenbaren Fahrtkosten zu liefern.
Außerdem befindet sich ein direkter Link zu Google Maps in der Detailansicht zu den Spielorten,
sodass Schiedsrichter direkt auf ihrem Smartphone Maps als Navigationsgerät nutzen können.

#### GeoDaten
Als Dienst zur Berechnung der GeoDaten wird [**OpenRouteService**](https://openrouteservice.org/) 
genutzt, über einen kostenfreien API-KEY. Dies kann bei erhöhter Auslastung der App dazu führen,
dass die täglichen Nutzungs-Quoten dieses Keys ausgelastet werden, womit diese jeweils zu nutzenden
Dienste (Directions für die Routenplanung, und Geocode für die Übersetzung eines Standortes in Koordinaten)
für diesen Tag nicht mehr nutzbar sind.

#### App-Berechtigung
Weiterhin wird für die automatische Standort-Berechnung Zugriff auf die Android-Berechtigung "Standort"
gebraucht. Sollte diese Berechtigung nicht erteilt werden, kann ausschließlich die Standort-Berechnung
über die Texteingabe erfolgen.

#### Code-Freigabe
Falls jemand anderes die Lust hat, mehrere hundert Fußballvereine durchzuarbeiten, darf dieser jemand
gerne entweder diese App erweitern (mir reichen theoretisch die Vereinsdaten + Koordinaten, Bezirksauswahl
und Verbandsauswahl würde ich übernehmen), oder diese App forken, um sie für seinen eigenen Bezirk zu nutzen.
Ansonsten dürfen gerne Issues oder Pull-Requests zur Verbesserung des aktuellen Codes gestellt werden.

#### Richtigkeit der Daten
Auf Korrektheit und Vollständigkeit wird kein Anspruch erhoben. Die Daten jedes einzelnen Vereins
wurden von mir händisch zusammengesucht und eingetragen, somit können sich Fehler eingeschlichen haben.
Bei Fund eines Fehlers bitte mich informieren, sodass ich diesen beheben kann.

#### Kontakt
Fabian Poker
fabianpoker1@web.de