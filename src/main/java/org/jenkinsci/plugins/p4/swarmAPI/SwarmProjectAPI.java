package org.jenkinsci.plugins.p4.swarmAPI;

import org.jenkinsci.plugins.p4.scm.P4Path;

import java.util.List;

public class SwarmProjectAPI {

	private Project project;

	public SwarmProjectAPI() {
	}

	public SwarmProjectAPI(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public static class Project {
		private List<Branch> branches;

		public Project(List<Branch> branches) {
			this.branches = branches;
		}

		public List<Branch> getBranches() {
			return branches;
		}
	}

	public static class Branch {
		private String id;
		private String name;
		private List<String> paths;

		public Branch(String id, String name, List<String> paths) {
			this.id = id;
			this.name = name;
			this.paths = paths;
		}

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		/**
		 * Return list of paths from a branch, but strip '/...'
		 *
		 * @return List of paths
		 */
		public P4Path getPath() {
			String path = paths.get(0);
			path = path.substring(0, path.lastIndexOf("/..."));
			P4Path p4Path = new P4Path(path);
			p4Path.setMappings(paths);
			return p4Path;
		}

		public List<String> getPaths() {
			return paths;
		}
	}
}
