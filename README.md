# TeoriaGrafow

Projekt to: na podstawie 3 danych
n - ilość wierzchołków,
r - promień zasięgu pojedynczego wierzchołka,
R - promień pola na którym mogą być wierzchołki (w układzie współrzędnych)
Wylosować graf którego wierzchołki znajdują się wewnątrz wyznaczonego pola w układzie współrzędnych. 
Co ważne, jeżeli pola zasięgów wierzchołków nachodzą na siebie, to takie wierzchołki muszą być połączone krawędzią.
Po wylosowaniu grafu należy go potrafić zapisać w postaci pliku *.gxl (jest to to samo co xml, tylko są tam specyficzne oznaczenia
wierzchołków, krawędzi itp.)
Po zapisaniu takiego grafu, należy też potrafić ten graf, lub jakikolwiek inny zapisany w formacie gxl z podobnymi wartościami - 
wczytać do pamięci programu , a następnie pokolorowac (ponumerować) wierzchołki, w taki sposób, aby użyć jak najmniejszą ilość kolorów,
a jednocześnie dwa wierzchołki, których pola zasięgów nachodzą na siebie (inaczej mówiąc - są połączone krawędzią), nie mogą mieć
tego samego koloru!
