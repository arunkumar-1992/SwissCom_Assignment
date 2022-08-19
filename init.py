import os
from distutils.sysconfig import get_python_lib
import toml


def read_packages():
    with open('pyproject.toml') as file:
        config_file = file.read()
    toml_config = toml.loads(config_file)

    return list(map(lambda obj: obj['include'], toml_config['tool']['poetry']['packages']))


def ensure_project_site_package():
    path_to_site_packages = get_python_lib()
    prj_path = os.path.dirname(os.path.realpath(__file__))

    if path_to_site_packages.lower().startswith(prj_path.lower()):
        return path_to_site_packages
    else:
        raise Exception('project not initialized, execute "poetry install" first')


def ensure_src_path(prj_path, package, path_to_site_packages):
    source_path = os.path.join(prj_path, package)
    if (os.path.exists(source_path)):
        # return os.path.relpath(source_path, start=path_to_site_packages)
        return os.path.abspath(source_path)
    else:
        raise Exception('source path {} does not exist'.format(source_path))


def write_src_config():
    path_to_site_packages = ensure_project_site_package()
    prj_path = os.path.dirname(__file__)

    with open(path_to_site_packages + '/sources.pth', 'wt') as config_file:
        config_file.write("#sources\n")
        for package in read_packages():
            src_path = ensure_src_path(prj_path, package, path_to_site_packages)
            config_file.write(src_path + "\n")


if __name__ == "__main__":
    write_src_config()
