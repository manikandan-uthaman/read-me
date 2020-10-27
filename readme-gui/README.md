# ReadmeGui

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 9.1.11.

## Responsive

Developed using `Mobile-First` strategy and implemented responsive design using media queries.

## Development server

Run `npm run start` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files. Edit `proxy.conf.json` with the backend server details

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Docker
To create a docker image you can use the following command:

```shell
docker build -t readme-gui .
```

To run the docker image use:

```shell
docker container run --publish 80:80 readme-gui
```