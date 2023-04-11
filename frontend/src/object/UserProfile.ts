export interface ProfessionalStory {
    company: string
    title: string
    location: string
    date: string
    tags: string[]
    content: string[]
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