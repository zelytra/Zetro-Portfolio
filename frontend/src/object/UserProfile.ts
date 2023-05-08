export interface User {
    title: string
    firstName: string
    lastName: string
    resume: string
    github: string
    linkedin: string
    instagram: string
    twitter: string
}

export interface HeaderSite {
    home: string
    projects: string
    blogs: string
    templates: string
    curriculum: string
}

export interface FooterSite {
    resume: string
    develop: string
    facebook: string
    linkedin: string
    twitter: string
    figma: string
    shortcut: [
        {
            title: string
            content:
                [
                    {
                        name: string
                        link: string
                    }]
        }
    ]
}


export interface Professional {
    title: string
    subTitle: string
    stories: ProfessionalStory[]
}

export interface ProfessionalStory {
    company: string
    title: string
    location: string
    date: string
    tags: string[]
    content: string[]
}

export interface School {
    title: string
    subTitle: string
    resume: string
    schools: SchoolStory[]
}

export interface Service {
    title: string
    subTitle: string
    cards: [
        {
            title: string
            content: string
        }
    ]
}

export interface SchoolStory {
    location: string
    name: string
    date: string
}

export interface Skill {
    name: string
    level: number
}

export interface SoftwareSkill {
    title: string
    subTitle: string
    skills: Skill[]
}

export interface Range {
    min: number,
    max: number
}
