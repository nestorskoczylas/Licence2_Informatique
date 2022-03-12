<?php

function elementBuilder(string $elementType,string  $content,string $elementClass="") : string {
	if ($elementClass == NULL) {
		return "<$elementType>$content</$elementType>";
	}
	else {
		return "<$elementType class=$elementClass>$content</$elementType>";
	}
}

function authorsToHTML(string $authors) : string {
	$author = explode(" - ", $authors);
	return "<span>$author[0]<span> <span>$author[1]</span>";
}


function coverToHTML(string $fileName) : string {
	return "<img src='couvertures/$fileName' alt='image de couverture' />";
}


function propertyToHTML(string $propName, string $propValue) : string {
	if ($propName = "titre") {
		return "<h2 class=$propName>$propValue</h2>";
	}
	elseif ($propName = "couverture") {
		return "<div class=$propName>coverToHTML($propValue)</div>";
	}
	elseif ($propName = "auteurs") {
		return "<div class=$propName>authorsToHTML($propValue)</div>";
	}
	elseif ($propName = "annee") {
		return "<time class=$propName>$propValue</time>";
	}
	else {
		return "<div class=$propName>$propValue</div>";
	}
}

function bookToHTML(array $book) : string {
	$res1 = "";
	$res2 = '<div class="description">';
	foreach ($book as $key => $value){
		if ($key == "couverture"){
			$res1 .= "<div class=$key><img src='couvertures/$value' alt='image de couverture' /></div>"."\n";
		}
		else {
			$res2 .= propertyToHTML($key, $value)."\n";
		}
	}
	return  '<article class="livre">'.$res1.$res2."</div></article>";
}
/*
function bookToHTML(array $book) : string {
	foreach ($book as $propName => $propValue) {
		if ($propName == "couverture") {
			$res = "<div class=$propName><img src='couvertures/$propValue' alt='image de couverture' /></div>";
		}
		elseif ($propName != "couverture") {
			$res .= "<div class='description'>propertyToHTML($propName, $propValue)</div>";
		}
	}
	return $res;
}*/


// exercice 2

function libraryToHTML(BookReader $reader) : string {
        $result = '';
        $book = $reader->readBook();
        while ($book !== null) {
            $result .= bookToHTML($book);
            $book = $reader->readBook();
        }
        return $result;
    }
?>
