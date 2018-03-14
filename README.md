# Elasticsearch Phonetic Analysis plugin for pt-BR

This is a custom Phonetic Analysis plugin for brazilian portuguese using [MTFN](https://github.com/ruliana/MTFN) algorithm - an implementation of [Metaphone](https://en.wikipedia.org/wiki/Metaphone) for pt-BR (and mostly compatible with pt-PT).

## Pre-requisites

* JDK 1.8
* Maven 3.x
* Elasticsearch 6.2.1

## Building & Packaging

First of all, make sure that Maven can use MTFN as a dependency. At this time, it is not available in Maven Central, so you can add it to your private repository or install it in your local machine.

```bash
git clone https://github.com/ruliana/MTFN.git
cd MTFN
mvn clean install
```

Then building this plugin is easy as pie.

```bash
mvn clean package
```

You will find the installation package at `./target/releases/`.

## Installation

This plugin can be installed using the plugin manager, in offline installation mode.
To install analysis-mtfn from your local file system at `/path/to/analysis-mtfn.zip`:

```bash
sudo bin/elasticsearch-plugin install file:///path/to/analysis-mtfn.zip
```

Find more information about Elasticsearch plugin offline installation at [Plugin Management » Custom URL or file system](https://www.elastic.co/guide/en/elasticsearch/plugins/current/plugin-management-custom-url.html).

## Removal

The plugin can be removed with the following command:

```bash
sudo bin/elasticsearch-plugin remove analysis-mtfn
```

## Configuration

You can configure your index to support phonetic searches in brazilian portuguese by adding this plugin as a filter with type `phonetic_br` to your index settings, defining a new analyzer and binding it to a field mapping.

```json
{
  "settings": {
    "analysis": {
      "filter": {
        "brazilian_phonetic": {
          "type": "phonetic_br"
        }
      },
      "analyzer": {
        "brazilian_phonetic": {
          "type": "custom",
          "tokenizer": "standard",
          "filter": [
            "brazilian_phonetic"
          ]
        }
      }
    }
  },
  "mappings": {
    "properties": {
      "nome": {
        "type": "text",
        "fields": {
          "phonetic": {
            "type": "text",
            "index": true,
            "analyzer": "brazilian_phonetic"
          }
        }
      }
    }
  }
}
```

## Contributing

_To be defined_
