export interface Project {
    banner: string
    name: string
    link: string
    tags: string[]

    title: string
    description: string
    icon: string
    contents: Object[]
}

export interface Content {
    title: string
    type: string
}

export interface BasicText extends Content {
    text: string
}

export interface ImageText extends Content {
    text: string
    image: string
}