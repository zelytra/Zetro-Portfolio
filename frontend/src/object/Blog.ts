import {ProjectFilter} from "@/object/Project";

export interface Blog {
    url: string
    name: string
    banner: string
    urlName: string
    tags: string[]
    date: string
    description: string
}

export interface BlogProvider {
    title: string
    subTitle: string
    filters: ProjectFilter[]
}
