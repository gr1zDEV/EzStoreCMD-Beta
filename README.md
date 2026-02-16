# EZStoreCmd

EZStoreCmd is a Paper 1.21.x plugin that provides a simple `/store` command and an admin `/ezstore reload` command.

## Features

- `/store`
  - Sends configured store message lines.
  - Replaces `%link%` with `message.link` from `config.yml`.
  - Plays an optional configurable sound for players.
- `/ezstore reload`
  - Reloads `config.yml`.
  - Sends configured reload message lines.
  - Requires `ezstore.admin` for players; console can always run it.

## Build

```bash
mvn clean package
```

The built plugin jar is generated under `target/`.

## Commands

- `/store`
- `/ezstore reload`

## Permission

- `ezstore.admin` (default: op)

## Configuration

Default `config.yml`:

```yml
message:
  reload: 
    -  "&#00A4FC&l•&r &f&nReloaded the config!"
  store: 
   -  "&#00A4FCᴊᴏɪɴ ᴛʜᴇ 2bz.org ᴄᴏᴍᴍᴜɴɪᴛʏ"
   -  "&#00A4FC&l•&r &f&n%link%"
  link: "store.2bz.org" 

sounds:
  pling:
    enabled: true
    sound: BLOCK_NOTE_BLOCK_PLING
    volume: 0.5
    pitch: 1.0
```

## Notes

- Supports hex color syntax `&#RRGGBB` and legacy color/formatting codes (`&l`, `&r`, `&f`, `&n`, etc.).
- Invalid configured sound names are handled safely with a warning in console.
