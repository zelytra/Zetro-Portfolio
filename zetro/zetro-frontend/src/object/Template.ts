import {ProjectFilter} from "@/object/Project";

export interface Template {
    banner: string
    name: string
    url: string
    date: string
    price: number
    tags: string[]
    redirection: string
}

export interface TemplateProvider {
    title: string
    subTitle: string
    filters: ProjectFilter[]
}
