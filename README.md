# TabText
> Simple to use Tablist Header/Footer Manager, powered by MiniMessage!

## Setup

> **NOTE!** You need to use [Paper](https://papermc.io), Spigot/Bukkit won't work!

Download the plugin, put it in `plugins/` and restart

## Set the Heading/Footing

To set the heading/Footing, simply edit the configuration file, save it and run `/tabtext reload`

## Config

```json
{
  "header": {
    "raw": "<gradient:red:blue:<x>>Hello, %player_name%!</gradient>",
    "animated": true,
    "animationSpeed": 0.1
  },
  "footer": {
    "raw": "<blue><b>Its an nice Day!</b></blue>",
    "animated": false,
    "animationSpeed": 0.0
  }
}
```
`header` - The header, **above** the Players

`footer` - The footer, **below** the Players

`raw` - The Message. Supports MiniMessage and Placeholders from PlaceholderAPI

`animated` - If set to true, the plugin will try to animate the Text
> **Note!** Animations are created by using the `power` feature of MiniMessage. If you want to use them, please make sure you include the placeholder `<x>` as the last argument of your Gradient. Refer to the [MiniMessage Documentation](https://docs.advntr.dev/minimessage/format.html#gradient) to learn more, or have  look at the example above.

`animationSpeed` - How fast the animation is. The higher the number - the faster the animation.

## ToDo
* [ ] Gui Builder for the Designs
* [ ] Multiple Design support
  * [ ] Gui/Commands to select

## License
THis Repository is licensed under `GPL v3`