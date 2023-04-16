<template>
  <section class="projects">
    <ProjectVue :project="projects[0]"/>
  </section>
</template>

<script setup lang="ts">
import type {Project} from "@/object/Project";
import ProjectVue from "@/vue/project/ProjectVue.vue"

const projects: Project[] = [
  {
    banner: "",
    link: "",
    name: "",
    tags: ["tag1", "tag2", "tag1", "tag2", "tag3"],
    contents: [
      {
        type: "Title",
        title: "Blabla",
        description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec urna nibh, pulvinar eget porttitor id, faucibus eget quam. Morbi sit amet est vitae tellus auctor tempus. Curabitur sed odio nulla. Proin quis aliquet nunc.",
        tags: ["tag1", "tag2", "tag1", "tag2", "tag3"],
        icon: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/2048px-LEGO_logo.svg.png"
      },
      {
        type: "BasicText",
        title: "Blabla",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec urna nibh, pulvinar eget porttitor id, faucibus eget quam. Morbi sit amet est vitae tellus auctor tempus. Curabitur sed odio nulla. Proin quis aliquet nunc. Nullam tincidunt augue nec neque ultrices, eu fermentum metus volutpat. Praesent lobortis sed libero non volutpat. Donec varius mi fermentum, laoreet sapien at, varius augue. Sed euismod commodo interdum. Suspendisse a turpis vitae risus ultrices varius. Aliquam eleifend tristique ultricies. In finibus laoreet neque eu facilisis. Pellentesque vel metus arcu. Ut at pulvinar urna. Aenean sed lacinia nisi. Nam nec felis faucibus, iaculis odio ut, vestibulum leo. Nullam a dui gravida, vehicula elit at, viverra odio. "
      },
      {
        type: "ImageText",
        title: "Blabla",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec urna nibh, pulvinar eget porttitor id, faucibus eget quam. Morbi sit amet est vitae tellus auctor tempus. Curabitur sed odio nulla. Proin quis aliquet nunc. Nullam tincidunt augue nec neque ultrices, eu fermentum metus volutpat. Praesent lobortis sed libero non volutpat. Donec varius mi fermentum, laoreet sapien at, varius augue. Sed euismod commodo interdum. Suspendisse a turpis vitae risus ultrices varius. Aliquam eleifend tristique ultricies. In finibus laoreet neque eu facilisis. Pellentesque vel metus arcu. Ut at pulvinar urna. Aenean sed lacinia nisi. Nam nec felis faucibus, iaculis odio ut, vestibulum leo. Nullam a dui gravida, vehicula elit at, viverra odio. ",
        image: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/2048px-LEGO_logo.svg.png"
      },
      {
        type: "BigImageText",
        title: "Blabla",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec urna nibh, pulvinar eget porttitor id, faucibus eget quam. Morbi sit amet est vitae tellus auctor tempus. Curabitur sed odio nulla. Proin quis aliquet nunc. Nullam tincidunt augue nec neque ultrices, eu fermentum metus volutpat. Praesent lobortis sed libero non volutpat. Donec varius mi fermentum, laoreet sapien at, varius augue. Sed euismod commodo interdum. Suspendisse a turpis vitae risus ultrices varius. Aliquam eleifend tristique ultricies. In finibus laoreet neque eu facilisis. Pellentesque vel metus arcu. Ut at pulvinar urna. Aenean sed lacinia nisi. Nam nec felis faucibus, iaculis odio ut, vestibulum leo. Nullam a dui gravida, vehicula elit at, viverra odio. ",
        image: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/2048px-LEGO_logo.svg.png"
      },
      {
        type: "ProjectSkill",
        title: "Blabla",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec urna nibh, pulvinar eget porttitor id, faucibus eget quam. Morbi sit amet est vitae tellus auctor tempus. Curabitur sed odio nulla. Proin quis aliquet nunc. Nullam tincidunt augue nec neque ultrices, eu fermentum metus volutpat. Praesent lobortis sed libero non volutpat. Donec varius mi fermentum, laoreet sapien at, varius augue. Sed euismod commodo interdum. Suspendisse a turpis vitae risus ultrices varius.",
        skills: [
          {name: "Figma", level: 50},
          {name: "Figma", level: 50},
          {name: "Figma", level: 50}
        ]
      },
      {
        type: "Contributor",
        title: "Blabla",
        contributors: [
          {
            icon: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/2048px-LEGO_logo.svg.png",
            name: "Zetro",
            tags: ["Designer", "Graphiste"]
          },
          {
            icon: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/2048px-LEGO_logo.svg.png",
            name: "Zetro",
            tags: ["Designer", "Graphiste"]
          },
          {
            icon: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/LEGO_logo.svg/2048px-LEGO_logo.svg.png",
            name: "Zetro",
            tags: ["Designer", "Graphiste"]
          },
        ]
      },
    ]
  }
]
//const selectedProjects = ref<Project>()
</script>

<style scoped lang="scss">
section.project {
  margin: 80px 20%;
  overflow: hidden;
}
</style>
