import axios from "axios";

export class HTTPAxios {

    private axios;
    private readonly json: any;
    private readonly path: string;

    private readonly header = {

    }

    //TODO Dynamic lang request within store
    private readonly url = import.meta.env.VITE_GITHUB_HOST + "fr/";
    public isAuth = false;

    constructor(path: string, json?: any, isAuth?: boolean) {
        this.path = path;
        this.json = json;
        if (isAuth) this.isAuth = isAuth;

        this.axios = axios.create({
            baseURL: this.url,
            timeout: 10000,
            headers: this.header
        });
    }

    async get() {
        console.debug("[GET] " + this.url + this.path)
        const urlPath = this.url + this.path;
        return await this.axios.get(urlPath);
    }

    async post(options: any) {
        console.debug("[POST] " + this.url + this.path)
        const urlPath = this.url + this.path;
        return await this.axios.post(urlPath, this.json, options)
    }

    async delete() {
        console.debug("[DELETE] " + this.url + this.path)
        const urlPath = this.url + this.path;
        return await this.axios.delete(urlPath, this.json)
    }

    async patch() {
        console.debug("[PATCH] " + this.url + this.path)
        const urlPath = this.url + this.path;
        return await this.axios.patch(urlPath, this.json)
    }
}
