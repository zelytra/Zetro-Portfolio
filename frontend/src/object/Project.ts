export interface Project {
    banner: string
    name: string
    link: string
    tags: string[]
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

export interface BigImageText extends Content {
    text: string
    image: string
}

export interface Title extends Content {
    description: string
    icon: string
    tags: []
}
