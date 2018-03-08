# Elasticsearch Phonetic Analysis plugin for pt-BR

This is a custom Phonetic Analysis plugin for brazilian portuguese using [MTFN](https://github.com/ruliana/MTFN) algorithm - an implementation of [Metaphone](https://en.wikipedia.org/wiki/Metaphone) for pt-BR (and mostly compatible with pt-PT).

## Pre-requisites

* JDK 1.8
* Maven 3.x
* Elasticsearch 6.2.1

## Building & Testing

_To be defined_

## Installation

This plugin can be installed using the plugin manager, in offline installation mode.
To install analysis-mtfn from your local file system at /path/to/analysis-mtfn.zip:

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

_This section will describe how to configure your brand new index to MTFN phonetic analisys._

## Contributing

_To be defined_

